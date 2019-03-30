package com.youfan.reduce;

import com.youfan.entity.BrandLike;
import com.youfan.entity.UseTypeInfo;
import com.youfan.util.MongoUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.bson.Document;

/**
 * Created by li on 2019/1/6.
 */
public class UseTypeSink implements SinkFunction<UseTypeInfo> {
    @Override
    public void invoke(UseTypeInfo value, Context context) throws Exception {
        String usetype = value.getUsetype();
        long count = value.getCount();
        Document doc = MongoUtils.findoneby("usetypestatics","youfanPortrait",usetype);
        if(doc == null){
            doc = new Document();
            doc.put("info",usetype);
            doc.put("count",count);
        }else{
            Long countpre = doc.getLong("count");
            Long total = countpre+count;
            doc.put("count",total);
        }
        MongoUtils.saveorupdatemongo("usetypestatics","youfanPortrait",doc);
    }
}
