
public class SavingsAccount extends Account{

	public SavingsAccount(String bankName_, String actNumber_, String actName_, double balance_, double annualInterestRate_) {
		bankName=bankName_;
		actNumber=actNumber_;
		actName=actName_;
		balance=balance_;
		annualInterestRate=annualInterestRate_;
	
	}
	
	public SavingsAccount() {
	}
	@Override
	public void withdraw(double amt) {
		   if(this.balance-amt>=0){
			     this.balance= balance-amt;
			   }
			   else {
			     System.out.println("Prevent overdraft activated(balance should not go below zero)");
			   }
	}
}
