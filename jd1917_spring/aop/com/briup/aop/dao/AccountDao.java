package com.briup.aop.dao;

import com.briup.aop.bean.Account;

public interface AccountDao {
	//ȡ�� �˺ż�ȥ����Ǯ
	void withdraw(Account acc,double amt);
	//��� �˺ż��϶���Ǯ
	void deposit(Account acc,double amt);

}
