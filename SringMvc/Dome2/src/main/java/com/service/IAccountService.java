package com.service;

import com.pojo.Account;

import java.util.List;

public interface IAccountService {
    List<Account> fineAll();
    void saceAccount(Account account);
}
