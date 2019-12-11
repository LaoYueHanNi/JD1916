package Work;

public class Account {
	protected double balance;//Óà¶î¢
	public Account(double balance) {
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	public boolean deposit(double amount) {
		//£¬amountÎª´æÈë½ð¶î
		balance+=amount;
		return true;
	}
	public boolean withdraw(double amount) {
		if(amount>balance) {
			return false;
		}
		else {
			balance-=amount;
			return true;
		}
	}
	
}
