package runnable_tasks;

import java.util.HashMap;

import com.app.core.Student;
import static java.lang.Thread.currentThread;
import static utils.CollectionUtils.sortStudentsAsGPA;
import static utils.IOUtils.storeData;

import java.io.IOException;

public class GPASorterTask implements Runnable {
	//state : non static , non transient data members => instance vars
	private HashMap<String, Student> map;
	private String fileName;	

	public GPASorterTask(HashMap<String, Student> map, String fileName) {
		super();
		this.map = map;
		this.fileName = fileName;
		System.out.println("in ctor invoked by : "+currentThread().getName());//main
	}
	@Override
	public void run() {
		System.out.println(currentThread().getName()+" strted ");
		try {
			//sort the students n store data
			storeData(sortStudentsAsGPA(map), fileName);  
		} catch (Exception e) {
			System.out.println(currentThread().getName()+" got err "+e);
		}
		System.out.println(currentThread().getName()+" over ");
	}

}
