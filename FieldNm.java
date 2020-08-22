package proj;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class FieldNm 
{
	//SetVal st=new SetVal();
	ArrayList<String> colNames1=new ArrayList<String>();
	ArrayList<String> colNames2=new ArrayList<String>();
	ArrayList<String> values=new ArrayList<String>();
	 ArrayList<ArrayList<String>> fields=new ArrayList<ArrayList<String>>();
	public void setFieldNm(MongoClient client,MongoDatabase db,String cls)
	{
	try
	{
		//MongoDatabase db=client.getDatabase(dbs);
		MongoCollection<Document> c=db.getCollection(cls);
		FindIterable<Document> i1=c.find();
		Set<String> keys;
		for(Document d:i1)
		{
			keys=d.keySet();
			for(String k:keys)
			 {
				String x=k.toUpperCase();
				if(colNames2.contains(x))
					continue;
				else 
				{
				    colNames1.add(k); 
				    colNames2.add(x);
				 
				 }
			 }
		}
		
	}
	
	catch(Exception e)
	{
		
	}
	}//close of function
	public ArrayList<String> getFieldNm() //this will retuen field names
	{
		return colNames1;
	}
	public void setValues(MongoDatabase db,String cls) //will set data of fields
	{
		//fields.add(colNames1);
		
		try 
		{
			MongoCollection<Document> c=db.getCollection(cls);
			TreeMap<String,String> map=new TreeMap<String,String>();
			FindIterable<Document> i1=c.find();
			Set<String> keys;
			int i=0;
			for(Document d:i1)
			{
				keys=d.keySet();
				 for(String k:keys)
				 {
					 //to solve problem of upper lower case mismatch in field names
						//convert field names to uppercase
						 map.put(k.toUpperCase(), d.get(k).toString());  
				 }
				 for(int y=0;y<colNames1.size();y++)
				 {
					 if(map.containsKey(colNames2.get(y))) 
					 values.add(map.get(colNames2.get(y)));
					 else
						 values.add(" ");
				 }
				 set(new ArrayList<String>(values), i);
				 values.clear();
				 map.clear();
				 i++;
			 }
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void set( ArrayList<String> arr,int row)
	  {
		  
		  fields.add(row, arr);
	  }
	
	public ArrayList<ArrayList<String>> getValues() //will get data and return it 
	{
		//fields=st.get();
		return fields;// return row data
	}
}
