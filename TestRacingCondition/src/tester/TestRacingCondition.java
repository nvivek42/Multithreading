package tester;

import com.app.core.JointAccount;

import runnable_tasks.CheckerTask;
import runnable_tasks.UpdaterTask;

public class TestRacingCondition {

	public static void main(String[] args) throws InterruptedException{
		// create SINGLE instance of the join account
		JointAccount account=new JointAccount(5000);
		//create tasks --attach them to thrds --start thrds
		//Thread(Runnble task, String name)
		Thread t1=new Thread(new UpdaterTask(account), "customer1");//NEW
		Thread t2=new Thread(new CheckerTask(account), "customer2");//NEW
		t1.start();
		t2.start();//runnable : 3 thrds 
		System.out.println("main waiting for child thrds.....");
		t1.join();
		t2.join();
		System.out.println("main over....");
	}

}
