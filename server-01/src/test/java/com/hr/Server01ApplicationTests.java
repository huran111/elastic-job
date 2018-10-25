package com.hr;

import com.hr.entity.User;
import com.hr.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ImportResource("classpath:spring/job.xml")
public class Server01ApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
	}
	@Test
	//@Transactional
	public  void saveUser(){
		for(int i=0;i<100;i++){
			int a=	(int) (Math.random() * 100);
			User user=new User();
			user.setAge(String.valueOf(a))
					.setName(String.valueOf(a))
					.setRandom(a);
	userRepository.save(user);
		}


	}
}
