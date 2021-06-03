package com.zx.demo.core.modules.school.model;

import com.zx.demo.base.common.orm.jpa.BaseEnity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Data
public class School extends BaseEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

}
