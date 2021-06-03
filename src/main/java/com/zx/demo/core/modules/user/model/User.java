package com.zx.demo.core.modules.user.model;

import com.zx.demo.base.common.orm.jpa.BaseEnity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Data
public class User extends BaseEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "PROJECT_ID")
    private Long projectId;


}
