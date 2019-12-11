package Work;

public class CheckingAccount extends Account{
	private double overdraft;//͸֧��� 
	public CheckingAccount(double balance,double overdraft) {
		super(balance);
		this.overdraft=overdraft;
	}
	public CheckingAccount(double balance) {
		super(balance);
		//����͸֧���Ϊ0 
		overdraft=0.0;
	}
	public boolean withdraw(double amount) {
		//ȡǮamountΪȡ�������amount>balance+overdraft����false��amount<=balance+overdraft����true 
		if(amount>balance+overdraft) {
			return false;
		}
		else {
			if(amount<=balance) {
				balance-=amount;
			}else {
				overdraft-=(amount-balance);
				balance=0;
			}
			return true;
			
		}
	}
	public double getOverdraft() {
		return overdraft;
	}
	
}
