package com.youfan.reduce;

import com.youfan.entity.BrandLike;
import com.youfan.entity.CarrierInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by li on 2019/1/6.
 */
public class BrandLikeReduce implements ReduceFunction<BrandLike> {
    @Override
    public BrandLike reduce(BrandLike brandLike, BrandLike t1) throws Exception {
        String brand = brandLike.getBrand();
        long count1 = brandLike.getCount();
        long count2 = t1.getCount();
        BrandLike brandLikefinal = new BrandLike();
        brandLikefinal.setBrand(brand);
        brandLikefinal.setCount(count1+count2);
        return brandLikefinal;
    }
}
