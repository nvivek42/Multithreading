package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.app.core.Student;

public interface IOUtils {
//add a static method , to store sorted student details in text file (using buffer)
	static void storeData(List<Student> list,String fileName) throws IOException
	{
		//chain of i/o streams :Java App ----> PW --> FW --->    Text File
		try(PrintWriter pw=new PrintWriter(new FileWriter(fileName)))
		{
			list.forEach(pw::println);//s -> pw.println(s)
//			for(Student s : list)
//				pw.println(s);
		}
	}
}
