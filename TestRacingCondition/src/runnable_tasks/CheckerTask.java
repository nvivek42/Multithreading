package runnable_tasks;

import com.app.core.JointAccount;

public class CheckerTask implements Runnable {
	// state : shared resource => joint bank acct
	private JointAccount account;

	public CheckerTask(JointAccount account) {
		super();
		this.account = account;
		System.out.println("ctor invoked by " + Thread.currentThread().getName());// main
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " strted ");
		try {
			while(true)
			{
				double balance = account.checkBalance();
				if (balance != 5000)
				{
					System.out.println("INVALID BALANCE!!!!!!!!!!!!!!!!!!!!!!!");
					System.exit(-1);//terminating the JVM
				}
				Thread.sleep(53);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over ");

	}

}
