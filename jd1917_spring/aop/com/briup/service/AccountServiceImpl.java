package com.briup.service;

import com.briup.aop.bean.Account;
import com.briup.aop.dao.AccountDao;

public class AccountServiceImpl implements IAccountService {
	private AccountDao accountDao;
	private Account account2;//¥Ê«Æµƒ’À∫≈

	@Override
	public void bankAction(Account account) {
		accountDao.withdraw(account, 100);
		accountDao.deposit(account2, 100);
		//throw new RuntimeException("");
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account getAccount() {
		return account2;
	}

	public void setAccount(Account account) {
		this.account2 = account;
	}

}
