package com.mapper;

import com.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "accountDao")
public interface IAccountDao {
    @Select("select * from account")
    List<Account> fineAll();
    @Insert(value= "insert into account(name,money) values(#{name},#{money})")
    void saceAccount(Account account);
}
