package com.hr.repository;

import com.hr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author huran
 * @Title: UserRepository
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2510:07
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor {
}
