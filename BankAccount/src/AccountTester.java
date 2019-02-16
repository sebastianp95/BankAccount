import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class AccountTester {


	public static void displayAccount(Account o) {
		System.out.println("----------------------");
		if(o instanceof CheckingAccount) {
			CheckingAccount checkingAccount = (CheckingAccount)o;
			System.out.println(checkingAccount.getCreationDate());
			System.out.println(checkingAccount.getAccuntName());
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
		Account checkingAccount = new CheckingAccount("BankOfAm", "123456", "SebastianPerez", 10000);
		Account savingAccount = new SavingsAccount("BankOfAm", "123456", "SebastianPerez", 100000000, 1.5);
		Check check = new Check();
		Account Account = new Account();


		System.out.println(checkingAccount.getAccuntName()+" "+ checkingAccount.getBalance());
		System.out.println("Enter bank name");
		String bankName=input.nextLine();
		System.out.println("Enter account number, account name (no spaces), initial balance, annual interest rate(in decimals) and overdraft limit");
		String actNumber=input.next();		
		String actName=input.next();
		double balance=input.nextDouble();
		double annualInterestRate=input.nextDouble();
		double overdraftLimit= input.nextDouble();

		checkingAccount = new CheckingAccount(bankName, actNumber, actName, balance);

		System.out.println("===== Checks Deposited=====");
		System.out.println("Enter check number, routing number, amount, date (mm/dd/yyyy), and bank name. \n Enter 0(zero) to finish");


		int checkNumber= input.nextInt();
		int routingNumber=input.nextInt();
		double amount=input.nextDouble();
		String date=input.next();
		bankName=input.next();

		try {
			Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(date);
			check=new Check(checkNumber, routingNumber, date1, amount,  bankName);

		} catch (ParseException e) {
			System.out.println("FGormat Incorrect");
			e.printStackTrace();
		}



		//		System.out.println(checkingAccount.getBankName()+" "+checkingAccount.getAccuntName()+" "+ checkingAccount.getBalance());

		displayAccount(checkingAccount);
	}

}
