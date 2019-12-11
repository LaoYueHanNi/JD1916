package com.briup.aop.dao;

import com.briup.aop.bean.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public void withdraw(Account acc, double amt) {
		System.out.println("��"+acc.getName()+"ȡ��"+amt);
	}

	@Override
	public void deposit(Account acc, double amt) {
		System.out.println("��"+acc.getName()+"����"+amt);
		
	}

}
