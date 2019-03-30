package com.youfan.task;

import com.youfan.entity.CarrierInfo;
import com.youfan.entity.YearBase;
import com.youfan.map.CarrierMap;
import com.youfan.map.YearBaseMap;
import com.youfan.reduce.CarrierReduce;
import com.youfan.reduce.YearBaseReduce;
import com.youfan.util.MongoUtils;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.bson.Document;

import java.util.List;

/**
 * Created by li on 2019/1/5.
 */
public class CarrierTask {
    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));

        DataSet<CarrierInfo> mapresult = text.map(new CarrierMap());
        DataSet<CarrierInfo> reduceresutl = mapresult.groupBy("groupfield").reduce(new CarrierReduce());
        try {
            List<CarrierInfo> reusltlist = reduceresutl.collect();
            for(CarrierInfo carrierInfo:reusltlist){
                    String carrier = carrierInfo.getCarrier();
                    Long count = carrierInfo.getCount();

                Document doc = MongoUtils.findoneby("carrierstatics","youfanPortrait",carrier);
                if(doc == null){
                    doc = new Document();
                    doc.put("info",carrier);
                    doc.put("count",count);
                }else{
                    Long countpre = doc.getLong("count");
                    Long total = countpre+count;
                    doc.put("count",total);
                }
                MongoUtils.saveorupdatemongo("carrierstatics","youfanPortrait",doc);
            }
            env.execute("carrier analy");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
