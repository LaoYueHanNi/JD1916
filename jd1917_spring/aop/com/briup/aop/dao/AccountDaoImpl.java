package com.briup.aop.dao;

import com.briup.aop.bean.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public void withdraw(Account acc, double amt) {
		System.out.println("从"+acc.getName()+"取了"+amt);
	}

	@Override
	public void deposit(Account acc, double amt) {
		System.out.println("往"+acc.getName()+"存了"+amt);
		
	}

}
