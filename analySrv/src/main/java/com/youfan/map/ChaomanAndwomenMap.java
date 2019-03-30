package com.youfan.map;

import com.alibaba.fastjson.JSONObject;
import com.youfan.entity.ChaomanAndWomenInfo;
import com.youfan.entity.UseTypeInfo;
import com.youfan.kafka.KafkaEvent;
import com.youfan.log.ScanProductLog;
import com.youfan.util.HbaseUtils;
import com.youfan.utils.MapUtils;
import com.youfan.utils.ReadProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li on 2019/1/6.
 */
public class ChaomanAndwomenMap implements FlatMapFunction<KafkaEvent,ChaomanAndWomenInfo>  {

    @Override
    public void flatMap(KafkaEvent kafkaEvent, Collector<ChaomanAndWomenInfo> collector) throws Exception {
            String data = kafkaEvent.getWord();
            ScanProductLog scanProductLog = JSONObject.parseObject(data,ScanProductLog.class);
            int userid = scanProductLog.getUserid();
            int productid = scanProductLog.getProductid();
            ChaomanAndWomenInfo chaomanAndWomenInfo = new ChaomanAndWomenInfo();
            chaomanAndWomenInfo.setUserid(userid+"");
            String chaotype = ReadProperties.getKey(productid+"","productChaoLiudic.properties");
            if(StringUtils.isNotBlank(chaotype)){
                chaomanAndWomenInfo.setChaotype(chaotype);
                chaomanAndWomenInfo.setCount(1l);
                chaomanAndWomenInfo.setGroupbyfield("chaomanAndWomen=="+userid);
                List<ChaomanAndWomenInfo> list = new ArrayList<ChaomanAndWomenInfo>();
                list.add(chaomanAndWomenInfo);
                collector.collect(chaomanAndWomenInfo);
            }

    }

}
