import java.util.*;
public class Account {
	String actNumber, actName, bankName;
	double balance, annualInterestRate;
	Date creationDate=new Date();
	public Account() {}

	public Account(String bankName_, String actNumber_, String actName_, double balance_, double annualInterestRate_) {
		this.bankName=bankName_;
		this.actNumber=actNumber_;
		this.balance=balance_;
		this.annualInterestRate=annualInterestRate_;


	}

	
	public double getBalance(){ return balance; }
	public double getInterestRate() { return annualInterestRate; }
	public String getAccuntName() { return actName; }
	public String getBankName() { return bankName; }

	public void setInterest(double rate) {

	}
	public void deposit(double amt) {
		balance=balance+amt;

	}
	public void withdraw(double amt) {
		
		if(balance>amt)
			balance=balance-amt;
	

	}

	public Date getCreationDate() {
		return creationDate;}

	public void applyInterest() {

	}


}
