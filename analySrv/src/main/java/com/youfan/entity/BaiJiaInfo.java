package com.youfan.entity;


import java.util.List;

/**
 * Created by li on 2019/1/5.
 */
public class BaiJiaInfo {
    private String baijiatype;//败家指数区段：0-20 、20-50 、50-70、70-80、80-90、90-100
    private String userid;
    private String createtime;
    private String amount ;
    private String paytype ;
    private String paytime;
    private String paystatus;//0、未支付 1、已支付 2、已退款
    private String couponamount;
    private String totalamount;
    private String refundamount;
    private Long count;//数量
    private String groupfield;//分组

    private List<BaiJiaInfo> list;

    public List<BaiJiaInfo> getList() {
        return list;
    }

    public void setList(List<BaiJiaInfo> list) {
        this.list = list;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    public String getCouponamount() {
        return couponamount;
    }

    public void setCouponamount(String couponamount) {
        this.couponamount = couponamount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getRefundamount() {
        return refundamount;
    }

    public void setRefundamount(String refundamount) {
        this.refundamount = refundamount;
    }

    public String getBaijiatype() {
        return baijiatype;
    }

    public void setBaijiatype(String baijiatype) {
        this.baijiatype = baijiatype;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getGroupfield() {
        return groupfield;
    }

    public void setGroupfield(String groupfield) {
        this.groupfield = groupfield;
    }
}
