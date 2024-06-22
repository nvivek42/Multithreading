package runnable_tasks;

import com.app.core.JointAccount;

public class UpdaterTask implements Runnable {
	// state : shared resource => joint bank acct
	private JointAccount account;

	public UpdaterTask(JointAccount account) {
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
				account.updateBalance(500);
				Thread.sleep(47);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got err " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over ");

	}

}
