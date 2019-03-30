package com.youfan.logic;

import com.youfan.entity.CarrierInfo;
import com.youfan.util.CarrierUtils;
import com.youfan.util.HbaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Random;

/**
 * Created by li on 2019/1/5.
 */
public class LogicMap implements MapFunction<String, LogicInfo>{
    @Override
    public LogicInfo map(String s) throws Exception {
        if(StringUtils.isBlank(s)){
            return null;
        }
        Random random = new Random();
        String [] temps = s.split(",");
        String variable1 = temps[0];
        String variable2 = temps[1];
        String variable3 = temps[2];
        String labase = temps[3];
        LogicInfo logicInfo = new LogicInfo();
        logicInfo.setVariable1(variable1);
        logicInfo.setVariable2(variable2);
        logicInfo.setVariable3(variable3);
        logicInfo.setLabase(labase);
        logicInfo.setGroupbyfield("logic=="+random.nextInt(10));
        return logicInfo;
    }
}
