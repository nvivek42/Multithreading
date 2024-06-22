package tester;

import java.io.IOException;

import utils.SynchroUtils;

public class Test1 {
	
	private static boolean exit=false;
	public static void main(String[] args) throws IOException,InterruptedException{
		// create SINGLE instance of SynchroUtils
		SynchroUtils util = new SynchroUtils();
		// Create 2 thrds using runnable : lambda expr , pass SAME instance to them ,
		// start them
	//Thread(Runnable instance , String name)
		Thread t1 = new Thread(() -> {
			while(!exit)
				util.test();
		}, "t1");//t1 : NEW
		Thread t2 = new Thread(() -> {
			while(!exit)
				util.test();
		}, "t2");//t2 : NEW
		t1.start();
		t2.start();//RUNABLE : 3
		// t1 : run() : while (!exit) : invoke test method : synched
		// t2 : run() : while (!exit) : invoke test method : synched
		// main : blocked on i/p : System.in.read()
		System.out.println("Press enter to stop");
		System.in.read();//main : Blocked on i/p
		// after user presses "Enter " :
		// t1 & t2 : should get over(exit=true)
		System.out.println("stopping exec of child thrds : exit");
		exit=true;
		// no orphans
		// main over.....
		t1.join();
		t2.join();
		System.out.println("main over.....");

	}

}
