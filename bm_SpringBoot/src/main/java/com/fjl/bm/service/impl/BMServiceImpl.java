package com.fjl.bm.service.impl;


import com.fjl.bm.dao.BMDao;
import com.fjl.bm.bean.*;
import com.fjl.bm.service.BMService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * TOOD
 *
 * @author luo
 * @version 1.0
 * @date 2020/9/9 15:04
 */
@Service
public class BMServiceImpl implements BMService
{
   @Resource
    private BMDao bmDao;
    @Override
    public List<Tb_bm> select() {
        return bmDao.selectAll();
    }

    @Override
    public Tb_bm selectOne(String bmid) {
        return bmDao.selectByBmid(bmid);
    }

    @Override
    public boolean createorder(String oid, String bmid, String username, int count, BigDecimal amount, String mark) {
        Integer v = null;
        try {
            v = bmDao.insertorder(oid,bmid,username,count,amount,mark);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (v != 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Tb_bmOrder> findByUsername(String username) {
        List<Tb_bmOrder> byUsername = null;
        try {
            return byUsername = bmDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
