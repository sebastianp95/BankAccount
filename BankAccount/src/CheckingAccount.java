import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class CheckingAccount extends Account  {

	double overdraftLimit;
	final double DEFAULT_OVERDRAFT_LIMIT = 100;
    ArrayList<Check> checksDeposited = new ArrayList<Check>();
    ArrayList<Check> checksCleared = new ArrayList<Check>(); 
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
		
		
		checksDeposited.add(newCheck);	
				
		
	}
	
	
	
	public void clearCheck(Check newCheck) {
		this.withdraw(newCheck.getAmount());
		
		
		checksCleared.add(newCheck);	
		
		
	}
	public void displayAllChecks() {	
		
		System.out.println("==== Transaction History ====");
		  System.out.println("--------- Summary for " + this.getAccountName() + " ---------");
		  System.out.println("======= Checks Deposited ======= ");
		  System.out.println("Number \tDate \tAmount \t Bank Name \t\tBank Routing Number");
		  double totalDeposited=0;
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		  
		  for(int i=0; i < checksDeposited.size() ;i++) {
			  
			  
			  System.out.println(checksDeposited.get(i).getNumber() + "\t" + dateFormat.format(checksDeposited.get(i).getDate()) + "\t"
			  + checksDeposited.get(i).getAmount() + "\t\t" + checksDeposited.get(i).getBankName() + "\t" + checksDeposited.get(i).getRoutingNumber());
			  
				totalDeposited += checksDeposited.get(i).getAmount();
			}
		  
			System.out.println("Total deposited: $" + totalDeposited);
			
			System.out.println("\n======= Checks cleared ======= ");
			  System.out.println("Number \tDate \tAmount ");
			  double totalCleared=0;
			  
			  
			  for(int j=0; j < checksCleared.size() ;j++) {
				  
				  System.out.println(checksCleared.get(j).getNumber() + "\t" + dateFormat.format(checksCleared.get(j).getDate()) + "\t"
				  + checksCleared.get(j).getAmount() );
				  
					totalCleared += checksCleared.get(j).getAmount();
				}
			  
			  System.out.println("Total Cleared: $" + totalCleared);
			  
			  System.out.println("Balance: "+ getBalance());
			 
	}
	

}





















