package com.youfan.reduce;

import com.youfan.entity.YearBase;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by li on 2019/1/5.
 */
public class YearBaseReduce implements ReduceFunction<YearBase>{
    @Override
    public YearBase reduce(YearBase yearBase, YearBase t1) throws Exception {
        String yeartype = yearBase.getYeartype();
        Long count1 = yearBase.getCount();

        Long count2 = t1.getCount();

        YearBase finalyearBase = new YearBase();
        finalyearBase.setYeartype(yeartype);
        finalyearBase.setCount(count1+count2);
        return finalyearBase;
    }
}
