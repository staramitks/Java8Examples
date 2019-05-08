package home.amit.java.basic.executor;

/**
 * @author singami2
 *
 */
public class AccountTransaction {
	
	private Account account;
	
	public AccountTransaction(Account acnt)
	{
		this.account=acnt;
	}

	
	public synchronized void withdraw ( long amount )
	{
		
		 if (account.getBalance()<amount)
		 {
			 
			 System.out.println("Less balance so holding withdrawal now...");
			try{
			 this.wait();
			}
			 catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		 }
		
			System.out.println("Allowing withdrawal now...");
			account.setBalance(account.getBalance()-amount);
			notifyAll();
	}
	
	public synchronized void deposit ( long amount )
	{
		
		System.out.println("Depositing money and notifying other waiting threads ");
		account.setBalance(account.getBalance()+amount);
		notifyAll();
		
	}
	
	
	public synchronized double getBalance ( )
	{
		
		return account.getBalance(); 
		
		
	}
}
