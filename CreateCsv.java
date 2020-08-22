package proj;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import com.opencsv.CSVWriter;
public class CreateCsv 
{
	public void Export( ArrayList<ArrayList<String>> fields,ArrayList<String> FieldNames,String FileName,String uname,String ID)
	{
		
		  String pth="/home/umer/softwares/apache-tomcat-8.5.31/webapps/Project2/Users/"+uname;
		  System.out.println(pth);
		  File f=new File(pth);
		  if(!f.exists())
		  f.mkdir();
		  
		
		  File f1=new File(pth+"/"+FileName+".csv");
		  String fname=pth+"/"+FileName+".csv";
		  if(f1.exists())
		 	System.out.println("already exists");
		  System.out.println(f1);
		  try
		    {
			Runtime.getRuntime().exec("chmod 777 "+pth); //invoking shell to grant permissions to file 
			Runtime.getRuntime().exec("chmod 777 "+fname);
			
			FileWriter outputfile=new FileWriter(f1);
			CSVWriter w=new CSVWriter(outputfile);
			
			
			String str[]=new String[FieldNames.size()];
			int count=0;
			for(int i=0;i<FieldNames.size();i++)
			{
				if(ID.equals("NO") && i==0)
				{
					count=1;
					continue;
				}
					
				if(count==1) {
				str[i-1]=FieldNames.get(i);}
				else{
				 str[i]=FieldNames.get(i);}	
			
			}
			
			
	          w.writeNext(str);
	       
	        for(int i=0;i<fields.size();i++)
	         {
	    	  if(ID.equals("NO")) {
	    	    for(int y=1;y<fields.get(i).size();y++)
	    	      {
	    		   if(count==1)
	    		  str[y-1]=fields.get(i).get(y);
	    		   else
	    			   str[y]=fields.get(i).get(y);
	         	  }
	    	  } 
	    	  
	    	  else
	    	  {
	    		  for(int y=0;y<fields.get(i).size();y++)
	    	      {
	    		 
	    		  str[y]=fields.get(i).get(y);
	         	  }
	    	  }
	    	  w.writeNext(str);  
	      }
	       
	       w.close();
	   
	} //close of try
	catch(Exception e)
	{
			
	}
		
	}


}
