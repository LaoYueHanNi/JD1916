package com.briup.thread;

import java.util.concurrent.locks.ReentrantLock;



//账号类
public class Account {
	private String accountNo;// id
	private double balance;// money
	// 创建可重入的lock对象
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

	// 存钱
	public synchronized double deposit(double amt) {
		if (amt <= 0)
			return 0;
		double temp = balance;
		temp += amt;
		balance = temp;
		return amt;
	}

	// 取钱
	public double withdraw(double amt) {
		// synchronized (this) {
		lock.isLocked();// 显示加锁
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
			lock.unlock();// 释放锁
		}

		// }
		return amt;
	}
}
