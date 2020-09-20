package com.fjl.bm.bean;

/**
 * TOOD
 *
 * @author luo
 * @version 1.0
 * @date 2020/9/13 11:05
 */
public class Tb_bmOrder {
    private String oid;
    private String count;
    private String bmid;
    private String ordertime;
    private String amount;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tb_bmOrder{" +
                "oid='" + oid + '\'' +
                ", count='" + count + '\'' +
                ", bmid='" + bmid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
