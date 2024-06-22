package tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DoBSorterTask;
import runnable_tasks.GPASorterTask;

import static utils.CollectionUtils.populateMap;

public class TestCollectionIOThreads {

	public static void main(String[] args) {
		// UI
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name for storing GPA sorted details");
			String fileName1 = sc.next();
			System.out.println("Enter file name for storing DoB sorted details");
			String fileName2 = sc.next();
			// get sample data from collection utils
			HashMap<String, Student> map = populateMap();
			// create tasks --attach thrds to the tasks --start the same
			// Thread(Runnable instance , String name)
			// gpa sorter
			Thread t1 = new Thread(new GPASorterTask(map, fileName1), "gpa_sorter");// t1 : NEW
			// dob sorter
			Thread t2 = new Thread(new DoBSorterTask(map, fileName2), "dob_sorter");// t2 : NEW
			// how many runnable(Ready + Running) thrds : 1 => main
			t1.start();
			t2.start();
			// how many runnable(Ready + Running) thrds : 1 => main + 2 child thrds = 3 
			// wait for child thrds to complete exec
			System.out.println("main waiting for child thrds to complete the exec");
			t1.join();//main : Blocked on join => waiting for t1
			t2.join();// main : Blocked on join => waiting for t2
			// main over
			System.out.println("main over.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
