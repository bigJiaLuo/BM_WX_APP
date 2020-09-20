//package com.fjl.bm.dao.impl;
//
//
//import com.fjl.bm.dao.BMDao;
//import com.fjl.bm.bean.*;
//import com.fjl.bm.utils.JDBCUtils;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * TOOD
// *
// * @author luo
// * @version 1.0
// * @date 2020/9/9 14:49
// */
//public class BMDaoImpl implements BMDao {
//    @Override
//    public List<Tb_bm> selectAll() {
//        String sql = "select * from tb_bm";
//        List<Tb_bm> bms = null;
//        try {
//            bms = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Tb_bm>(Tb_bm.class));
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }
//        return bms;
//    }
//
//    @Override
//    public Tb_bm selectByBmid(String bmid) {
//        String sql = "select * from tb_bm where bmid = ?";
//        Tb_bm tb_bm = null;
//        try {
//            tb_bm = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Tb_bm>(Tb_bm.class), bmid);
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return tb_bm;
//    }
//
//    @Override
//    public Integer insertorder(String oid, String bmid, String username, int count, BigDecimal amount, String mark) {
//        String sql = "insert into tb_order values(?,?,?,?,?,?)";
//        int update = jdbcTemplate.update(sql, oid, bmid, username, count, amount, mark);
//        return update;
//    }
//
//    @Override
//    public List<Tb_bmOrder> findByUsername(CharSequence username) {
//        String sql = "select * from tb_order where username = ?";
//        List<Tb_bmOrder> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Tb_bmOrder>(Tb_bmOrder.class), username);
//        return query;
//    }
//}
