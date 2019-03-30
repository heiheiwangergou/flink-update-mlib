package com.youfan.reduce;

import com.youfan.entity.BrandLike;
import com.youfan.entity.UseTypeInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by li on 2019/1/6.
 */
public class UseTypeReduce implements ReduceFunction<UseTypeInfo> {

    @Override
    public UseTypeInfo reduce(UseTypeInfo useTypeInfo, UseTypeInfo t1) throws Exception {
        String usertype = useTypeInfo.getUsetype();
        Long count1 = useTypeInfo.getCount();

        Long count2 = t1.getCount();

        UseTypeInfo useTypeInfofinal = new UseTypeInfo();
        useTypeInfofinal.setUsetype(usertype);
        useTypeInfofinal.setCount(count1+count2);
        return useTypeInfofinal;
    }
}
