package com.fjl.bm.dao;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BMDaoTest {

    @Resource
    private BMDao bmDao;
   /* @org.junit.Test
    public void insertorder() {
        BigDecimal bigDecimal = new BigDecimal(11.1);
        bmDao.insertorder("1","luo","1",1000,bigDecimal,"123");
    }*/
}