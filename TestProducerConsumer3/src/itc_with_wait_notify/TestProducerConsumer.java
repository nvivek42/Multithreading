package itc_with_wait_notify;

public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Utils2 u = new Utils2();
		String[] nms = { "Producer", "Consumer" };
		// produce task ---thrd --strt
		Producer p1 = new Producer(u);// thrd doesn't exist
		// Thread(Runnable inst,String nm)
		Thread t1 = new Thread(p1, nms[0]);// new
		t1.start();// rdy
		Thread.sleep(10);
		Consumer c1 = new Consumer(u);
		// Thread(Runnable inst,String nm)
		Thread t2 = new Thread(c1, nms[1]);// consumer thrd---new
		t2.start();// rdy pool
		// Thread.sleep(5);
		System.out.println("Press enter to exit");
		System.in.read();// main thrd Blocked on i/p
		p1.stop();
		c1.stop();
		System.out.println("main waiting for producer for max 1 sec , to complete exec");
		t1.join(1000);// main
		System.out.println("main waiting for consumer for max 1 sec , to complete exec");
		t2.join(1000);

		if (t1.isAlive()) // p : Blocked on wait
			t1.interrupt();// maint sending interrupt signla to t1 => t1 will get InterruptedExc ---run()
							// rets => dead thread
		if (t2.isAlive()) // c : Blocked on wait
			t2.interrupt();
		t1.join();
		t2.join();
		System.out.println("main over...");
	}

}
