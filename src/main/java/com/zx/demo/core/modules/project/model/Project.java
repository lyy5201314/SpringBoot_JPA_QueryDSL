package com.zx.demo.core.modules.project.model;

import com.zx.demo.base.common.orm.jpa.BaseEnity;
import com.zx.demo.core.modules.school.model.School;
import com.zx.demo.core.modules.user.model.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@ToString
@Data
public class Project extends BaseEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "projectId")
    private List<User> users = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private School school;
}
