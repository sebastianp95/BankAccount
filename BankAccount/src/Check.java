
import java.util.*;
public class Check {
	int number, routingNumber;
	Date date;
	double amount;
	String bankName;	

	public Check() {}
	public Check(int number_, int routingNumber_,Date date_, double amount_, String bankName_) {
		this.number=number_;
		this.routingNumber=routingNumber_;
		this.date=date_;
		this.amount=amount_;
		this.bankName=bankName_;
	}
	public Check(int number_,double amount_, Date date_ ) {
		this.number=number_;
		this.amount=amount_;
		this.date=date_;

	}


	public int getNumber() { return number; 	}


	public int getRoutingNumber() {	return routingNumber;	}


	public Date getDate() {		return date;	}


	public double getAmount() {		return amount;	}


	public String getBankName() {		return bankName;	}


}
