package com.service.impl;

import com.mapper.IAccountDao;
import com.pojo.Account;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Override
    public List<Account> fineAll() {
        System.out.println("查询所有！");
        return accountDao.fineAll();
    }

    @Override
    public void saceAccount(Account account) {
        accountDao.saceAccount(account);
    }
}
