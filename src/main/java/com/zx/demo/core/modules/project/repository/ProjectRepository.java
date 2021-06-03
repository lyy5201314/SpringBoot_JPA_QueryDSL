package com.zx.demo.core.modules.project.repository;

import com.zx.demo.core.modules.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>, QuerydslPredicateExecutor<Project> {

    List<Project> findByNameAndAddress(String name,String address);


}
