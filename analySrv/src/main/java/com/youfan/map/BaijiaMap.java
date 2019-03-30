package com.youfan.map;

import com.youfan.entity.BaiJiaInfo;
import com.youfan.entity.CarrierInfo;
import com.youfan.util.CarrierUtils;
import com.youfan.util.HbaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2019/1/5.
 */
public class BaijiaMap implements MapFunction<String, BaiJiaInfo>{
    @Override
    public BaiJiaInfo map(String s) throws Exception {
        if(StringUtils.isBlank(s)){
            return null;
        }

        String[] orderinfos = s.split(",");
        String id= orderinfos[0];
        String productid = orderinfos[1];
        String producttypeid = orderinfos[2];
        String createtime = orderinfos[3];
        String amount = orderinfos[4];
        String paytype = orderinfos[5];
        String paytime = orderinfos[6];
        String paystatus = orderinfos[7];
        String couponamount = orderinfos[8];
        String totalamount = orderinfos[9];
        String refundamount = orderinfos[10];
        String num = orderinfos[11];
        String userid = orderinfos[12];


        BaiJiaInfo baiJiaInfo = new BaiJiaInfo();
        baiJiaInfo.setUserid(userid);
        baiJiaInfo.setCreatetime(createtime);
        baiJiaInfo.setAmount(amount);
        baiJiaInfo.setPaytype(paytype);
        baiJiaInfo.setPaytime(paytime);
        baiJiaInfo.setPaystatus(paystatus);
        baiJiaInfo.setCouponamount(couponamount);
        baiJiaInfo.setTotalamount(totalamount);
        baiJiaInfo.setRefundamount(refundamount);
        String groupfield = "baijia=="+userid;
        baiJiaInfo.setGroupfield(groupfield);
        List<BaiJiaInfo> list = new ArrayList<BaiJiaInfo>();
        list.add(baiJiaInfo);
        return baiJiaInfo;
    }
}
