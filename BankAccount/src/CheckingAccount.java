import java.util.*;
public class CheckingAccount extends Account  {

	double overdraftLimit;
	final double DEFAULT_OVERDRAFT_LIMIT = 100;
    ArrayList<Check> checkDeposited, checksCLeared;
	int lastCheckCleared;
	
	public CheckingAccount(String bankName_, String actNumber_, String actName_, double balance_) {	
		bankName=bankName_;
		actNumber=actNumber_;
		actName=actName_;
		balance=balance_;
	}
	
	public CheckingAccount() {}
	
	@Override
	public void withdraw(double amt) {}
	
	public void depositCheck(Check newCheck) {}
	public void clearCheck(Check newCheck) {}
	public void displayAllChecks() {	}
	

}
