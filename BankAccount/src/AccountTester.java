import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class AccountTester {


	public static void displayAccount(Account o) {
		System.out.println("----------------------");
		if(o instanceof CheckingAccount) {
			CheckingAccount checkingAccount = (CheckingAccount)o;
			System.out.println(checkingAccount.getCreationDate());
			System.out.println(checkingAccount.getBankName());
			

		}
		else if(o instanceof SavingsAccount) {
			SavingsAccount savingsAccount = (SavingsAccount)o;
			System.out.println(savingsAccount.toString());
			System.out.println(savingsAccount.actName);


		}
		else
			System.out.println("Account not found.");
	}
	
	
		
	



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CheckingAccount checkingAccount = new CheckingAccount();
		Account savingAccount = new SavingsAccount("BankOfAm", "123456", "SebastianPerez", 100000000, 1.5);
		//		Check check = new Check();
		Account Account = new Account();


	   System.out.println("Esta es la prueba para verificar el funcionamiento de Github");
		System.out.println("Enter bank name");
		String bankName=input.nextLine();
		System.out.println("Enter account number, account name (no spaces), initial balance, annual interest rate(in decimals) and overdraft limit");
		String actNumber=input.next();		
		String actName=input.next();
		double balance=input.nextDouble();
		double annualInterestRate=input.nextDouble();
		double overdraftLimit= input.nextDouble();

		checkingAccount = new CheckingAccount(bankName, actNumber, actName, balance,annualInterestRate,overdraftLimit);

		System.out.println("\n===== Checks Deposited=====");
		System.out.println("Enter check number, routing number, amount, date (mm/dd/yyyy), and bank name. \n Enter 0(zero) to finish");


		while(true){
			int checkNumber= input.nextInt();
			if(checkNumber==0)
				break;
			int routingNumber=input.nextInt();
			double amount=input.nextDouble();
			String date=input.next();
			bankName=input.nextLine();

			Date date1 = null;
			try {
				date1= new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				System.out.println("Date format Incorrect");
				e.printStackTrace();
			}
			
			Check check=new Check(checkNumber, routingNumber, date1, amount,  bankName);
			
//			CheckingAccount checkingAccountTemp = new CheckingAccount();
			
			//add ArrayList type CHeck
			checkingAccount.depositCheck(check);
			
		}
		
		System.out.println("\n===== Checks Cleared=====");
		System.out.println("Enter check number,  amount, date (mm/dd/yyyy). \n Enter 0(zero) to finish");


		while(true){


			int checkNumber= input.nextInt();
			if(checkNumber==0)
				break;
			double amount=input.nextDouble();
			String date=input.nextLine();

			Date date1 = null;
			try {
				date1= new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				System.out.println("Date format Incorrect");
				e.printStackTrace();
			}
			
			
			Check check=new Check(checkNumber, amount,date1);
			
			
			
			checkingAccount.clearCheck(check);
			
			
		}


		checkingAccount.displayAllChecks();
		displayAccount(checkingAccount);
		
	}

}
