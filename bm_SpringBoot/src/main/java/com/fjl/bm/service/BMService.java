package com.fjl.bm.service;

import com.fjl.bm.bean.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * TOOD
 *
 * @author luo
 * @version 1.0
 * @date 2020/9/9 15:03
 */
public interface BMService {
    public List<Tb_bm> select();

    /**
     * 根据bmid查询一个保姆信息
     * @param bmid
     * @return
     */
    Tb_bm selectOne(String bmid);
    /**
     * 添加订单
     * @param oid
     * @param bmid
     * @param username
     * @param count
     * @param amount
     * @param mark
     * @return
     */
    boolean createorder(String oid, String bmid, String username, int count, BigDecimal amount, String mark);

    /**
     * 根据老板名查询预约的所有保姆
     * @param username
     * @return
     */
    List<Tb_bmOrder> findByUsername(String username);
}
