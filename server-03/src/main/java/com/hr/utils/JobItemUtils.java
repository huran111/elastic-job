package com.hr.utils;

import com.dangdang.ddframe.job.api.ShardingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huran
 * @Title: JobItemUtils
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2515:44
 */
public class JobItemUtils {
    /**
     * 当前分片项根据：随机字段值/总分片数，得出每个分片项要取的随机数范围， 模数：字段值%总分片数，放到最后一个分片项
     *
     * @param shardingContext
     * @return
     */
    public static List<Integer> calItems(ShardingContext shardingContext) {
        List<Integer> curSplits = new ArrayList<>();
        int totalSharding = shardingContext.getShardingTotalCount();
        int item = shardingContext.getShardingItem();
        int totalSplit = 100;
        Integer pagesize = totalSplit / totalSharding;
        for (Integer i = 0; i < pagesize; i++) {
            Integer index = item * pagesize + i;
            curSplits.add(index);
        }
        if (item == (totalSharding - 1)) {
            for (int j = (item + 1) * pagesize; j < totalSplit; j++) {
                curSplits.add(j);
            }
        }
        return curSplits;
    }
}
