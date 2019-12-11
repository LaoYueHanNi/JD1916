package Work;

public class CheckingAccount extends Account{
	private double overdraft;//透支额度 
	public CheckingAccount(double balance,double overdraft) {
		super(balance);
		this.overdraft=overdraft;
	}
	public CheckingAccount(double balance) {
		super(balance);
		//设置透支额度为0 
		overdraft=0.0;
	}
	public boolean withdraw(double amount) {
		//取钱amount为取出金额，如果amount>balance+overdraft返回false，amount<=balance+overdraft返回true 
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
