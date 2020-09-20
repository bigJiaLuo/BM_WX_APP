package com.fjl.bm.dao;

import com.fjl.bm.bean.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * TOOD
 *
 * @author luo
 * @version 1.0
 * @date 2020/9/9 14:48
 */
public interface BMDao {

    /**
     * 查询所有保姆列表
     * @return
     */
    public List<Tb_bm> selectAll();

    /**
     * 根据bmid查询对应的一条保姆记录
     * @param bmid
     * @return
     */
    Tb_bm selectByBmid(String bmid);
    /**
     *插入一条订单记录
     * @param oid
     * @param bmid
     * @param username
     * @param count
     * @param amount
     * @param mark
     * @return
     */
    Integer insertorder(String oid, String bmid, String username, int count, BigDecimal amount, String mark);

    /**
     * 根据用户名 查找其所有预约的保姆
     * @param username
     * @return
     */
    List<Tb_bmOrder> findByUsername(String username);
}
