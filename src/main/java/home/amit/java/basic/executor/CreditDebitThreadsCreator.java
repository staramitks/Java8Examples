/**
 * 
 */
package home.amit.java.basic.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author singami2
 *
 */
public class CreditDebitThreadsCreator {
	
	public static void main (String args[])
	{
		
		Account account= new Account();
		account.setAcntHoldrName("Amit Singh");
		account.setKycNum("4420157852651424");
		account.setBalance(10.0);
		account.setAcntNum("12312341242314");
		AccountTransaction accountTransaction= new AccountTransaction(account);
		
		Thread withdrawThread=new Thread(()->accountTransaction.withdraw(100000), "WithdrawalThread");
		Thread depositThread=new Thread(()->accountTransaction. deposit(100250), "DepositThread");
		Thread balanceThread=new Thread(()->System.out.println("Final Balance is "+accountTransaction.getBalance()), "BalanceThread");
//		withdrawThread.start();
//		depositThread.start();
//		Problematic as it can get triggerred in first go as well.. This must be trigerred when Deposit and Withdrawal have been executed
//		balanceThread.start();
		
		/* This will work fine as balance thread is trigerred after two are executed and completed*/
		
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		executorService.submit(withdrawThread);
		executorService.submit(depositThread);
		executorService.shutdown();
		try {
			executorService.awaitTermination(100,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		balanceThread.start();
		
		
	}

}
