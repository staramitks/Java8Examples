/**
 * 
 */
package home.amit.java.basic.executor;

/**
 * @author guddoo
 *
 */
public class Account {
	
	private String acntNum;
	private double balance;
	private String acntHoldrName;
	private String kycNum;
	
	public Account()
	{}
	
	public String getAcntNum() {
		return acntNum;
	}
	public void setAcntNum(String acntNum) {
		this.acntNum = acntNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAcntHoldrName() {
		return acntHoldrName;
	}
	public void setAcntHoldrName(String acntHoldrName) {
		this.acntHoldrName = acntHoldrName;
	}

	public String getKycNum() {
		return kycNum;
	}

	public void setKycNum(String kycNum) {
		this.kycNum = kycNum;
	}
	
	

}
