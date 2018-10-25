package com.hr.controller;

import com.hr.entity.User;
import com.hr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author huran
 * @Title: SaveUserController
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2514:57
 */
@RestController
public class SaveUserController {
    @Autowired
    private UserRepository repository;
    @RequestMapping(value = "/saveUser")
    public void saveUser() {
        for(int i=0;i<100;i++){
            int a=	(int) (Math.random() * 100);
            User user=new User();
            user.setAge(String.valueOf(a))
                    .setName(String.valueOf(a))
                    .setRandom(a);
            repository.save(user);
        }
    }
}
