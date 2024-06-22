package daemon_thrds;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		// display details of the main thread : name , priority , thrd grp
		System.out.println("main thrd's dtls " + Thread.currentThread());//main , 5 , main
		// create instance of a class that imple Runnable
		RunnableTask task = new RunnableTask();// 1 : main
		// create named Threads(constr) n start the same
		//Thread (Runnable instance , String name)
		Thread t1 = new Thread(task, "one");
		Thread t2 = new Thread(task, "two");
		t2.setDaemon(true);
		Thread t3 = new Thread(task, "three");//one,two,three :  NEW : RUNNABLE --1 : main
		t1.start();
		t2.start();
		t3.start();// 4 threads : RUNNABLE

		
//		Thread.sleep(10000);
//		t1.interrupt();
//		t2.interrupt();
//		t3.interrupt();
		System.out.println("main over....");
	}

}
