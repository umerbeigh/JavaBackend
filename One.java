package proj;

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class One 
{
	public Object swtb(String db)
	{ Object t[] = null;
		System.out.println("help");
		try {
			MongoClient client=new MongoClient("localhost",27017);
			DB db1 = client.getDB(db);
			Set<String> col = db1.getCollectionNames();
			t=col.toArray();
		
			//Object d[]=t;
			
			/*for(int i=0;i<col.size();i++)
			{
				System.out.println(t[i]);
			}*/
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return t;
	}
	 

}
