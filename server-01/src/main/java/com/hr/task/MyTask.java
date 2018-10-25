package com.hr.task;

import com.hr.entity.User;
import com.hr.repository.UserRepository;

import java.util.concurrent.Callable;

/**
 * @author huran
 * @Title: MyTask
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2512:36
 */
public class MyTask implements Callable<Long> {
    private UserRepository userRepository;
    private Long id;

    public MyTask(UserRepository userRepository, Long id) {
        this.userRepository = userRepository;
        this.id = id;

    }

    @Override
    public Long call() throws Exception {

   /*     System.out.println("=====================>>>"+id);
        User user = userRepository.getOne(id);
        if (null != user) {
            System.out.println("user:"+Thread.currentThread().getName()+":"+user.toString());
            return 1L;
        }*/

        return 0L;
    }
}
