package com.hr.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.hr.entity.User;
import com.hr.repository.UserRepository;
import com.hr.utils.JobItemUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author huran
 * @Title: UserJob
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2510:10
 */
@Component
@Slf4j

public class UserJob implements SimpleJob {
    /**
     * 开启30个线程处理数据
     */
    private ExecutorService executorService = Executors.newFixedThreadPool(30);
    CompletionService<Long> completionService = new ExecutorCompletionService<Long>(executorService);
    @Autowired
    private UserRepository userRepository;
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("==========分片数为："+shardingContext.getShardingItem());
        //分片算法 得到该机器需要处理的随机数对应的数据
        List<Integer> random = JobItemUtils.calItems(shardingContext);
        for (Integer integer : random) {
            try {
                Specification specification=new Specification() {
                    @Nullable
                    @Override
                    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        List<Predicate> predicates = new ArrayList<>();
                        predicates.add(criteriaBuilder.equal(root.get("random"),integer));
                        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }
                };

                List<User> users=this.userRepository.findAll(specification);
                log.info("===================>>>>随机数为[{}]的数据,有多少[{}]",integer,users.size());
                //log.info("===================>>>>随机数为[{}]的数据,有多少[{}]",integer,users.size());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
