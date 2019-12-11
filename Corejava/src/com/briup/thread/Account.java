package com.briup.thread;

import java.util.concurrent.locks.ReentrantLock;



//�˺���
public class Account {
	private String accountNo;// id
	private double balance;// money
	// �����������lock����
	private final ReentrantLock lock = new ReentrantLock();

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	// ��Ǯ
	public synchronized double deposit(double amt) {
		if (amt <= 0)
			return 0;
		double temp = balance;
		temp += amt;
		balance = temp;
		return amt;
	}

	// ȡǮ
	public double withdraw(double amt) {
		// synchronized (this) {
		lock.isLocked();// ��ʾ����
		try {
			if (amt <= 0 || amt > balance)
				return 0;
			double temp = balance;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp -= amt;
			balance = temp;
		} finally {
			lock.unlock();// �ͷ���
		}

		// }
		return amt;
	}
}
