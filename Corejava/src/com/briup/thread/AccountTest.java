package com.briup.thread;

public class AccountTest extends Thread {
	private Account account;
	
	public AccountTest(String name,Account account) {
		super(name);
		this.account=account;
	}
	public void run() {
		//synchronized (account) {
			double amt=account.withdraw(1000);
			System.out.println(getName()+"��"+account.getAccountNo()+"�˺���ȡ��"+amt+" ���"+account.getBalance());
		//}
		
	}
	public static void main(String[] args) {
		Account a=new Account("9898",1000);
		Thread girl=new AccountTest("lucy",a);
		Thread boy=new AccountTest("tom",a);
		girl.start();
		boy.start();
	}
}
