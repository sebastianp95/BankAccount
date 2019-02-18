import java.util.*;
public class CheckingAccount extends Account  {

	double overdraftLimit;
	final double DEFAULT_OVERDRAFT_LIMIT = 100;
    ArrayList<Check> checksDeposited , checksCleared;
	int lastCheckCleared;
	
	
	
	
	
	public CheckingAccount(String bankName_, String actNumber_, String actName_, double balance_,double annualInterestRate_ ,double overDraftLimit_) {	
		bankName=bankName_;
		actNumber=actNumber_;
		actName=actName_;
		balance=balance_;
		annualInterestRate=annualInterestRate_;
		if(overDraftLimit_>0)
			this.overdraftLimit=overDraftLimit_;
		else
			this.overdraftLimit=DEFAULT_OVERDRAFT_LIMIT;
		

	}
	
	public CheckingAccount() {
		this.overdraftLimit=DEFAULT_OVERDRAFT_LIMIT;
	}
	
	@Override
	public void withdraw(double amt) {
		if(amt<=balance)
			balance = balance-amt;
		else 
			System.out.print("Not enough money to complete transaction!");
	}
	
	
	
	public void depositCheck(Check newCheck) {
		balance = balance+(newCheck.getAmount());
		checksDeposited = new ArrayList<Check>();
		checksDeposited.add(newCheck);	
				
		
	}
	
	
	
	public void clearCheck(Check newCheck) {
		this.withdraw(newCheck.getAmount());
		
		checksCleared = new ArrayList<Check>();
		checksCleared.add(newCheck);	
		
		
	}
	public void displayAllChecks() {	
		
		System.out.println("==== Transaction History ====");
		  System.out.println("--------- Summary for " + getAccountName() + " ---------");
		  System.out.println("======= Checks Deposited ======= ");
		  System.out.println("Number \tDate \tAmount \t Bank Name \t\tBank Routing Number");
		  double totalDeposited=0;
		  for(int i=0;i<checksDeposited.size();i++) {
			  
			  System.out.println(checksDeposited.get(i).getNumber() + "\t" + checksDeposited.get(i).getDate() + "\t"
			  + checksDeposited.get(i).getAmount() + "\t\t" + checksDeposited.get(i).getBankName() + "\t" + checksDeposited.get(i).getRoutingNumber());
				totalDeposited += checksDeposited.get(i).getAmount();
			}
			System.out.println("Total deposited: $" + totalDeposited);
			 
			 
		
	}
	

}





















