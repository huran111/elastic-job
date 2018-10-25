package com.hr.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author huran
 * @Title: User
 * @ProjectName elastic-job
 * @Description: TODO
 * @date 2018/10/2510:00
 */
@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String age;
    private int random;

}
