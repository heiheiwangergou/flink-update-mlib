package com.youfan.entity;

import java.util.List;

/**
 * Created by li on 2019/1/6.
 */
public class ChaomanAndWomenInfo {
    private String chaotype;//1,潮男 ；2，潮女
    private String userid;//用户id
    private long count;
    private String groupbyfield;

    private List<ChaomanAndWomenInfo> list;

    public List<ChaomanAndWomenInfo> getList() {
        return list;
    }

    public void setList(List<ChaomanAndWomenInfo> list) {
        this.list = list;
    }

    public String getChaotype() {
        return chaotype;
    }

    public void setChaotype(String chaotype) {
        this.chaotype = chaotype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getGroupbyfield() {
        return groupbyfield;
    }

    public void setGroupbyfield(String groupbyfield) {
        this.groupbyfield = groupbyfield;
    }
}
