package com.test;

import com.mapper.IAccountDao;
import com.pojo.Account;
import com.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    @Test
    public void testSpring(){
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.fineAll();
    }
    @Test
    /**
     * 成功的测试！
     */
    public void testMybatis() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccountDao accountDao = (IAccountDao) sqlSession.getMapper(IAccountDao.class);
        for (Account account : accountDao.fineAll()){
            System.out.println(account);
        }
        sqlSession.close();
    }
}
