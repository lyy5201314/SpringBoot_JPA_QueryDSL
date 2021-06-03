package com.zx.demo.core.modules.school.repository;

import com.zx.demo.core.modules.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface SchoolRepository extends JpaRepository<School,Long>, QuerydslPredicateExecutor<School> {


}
