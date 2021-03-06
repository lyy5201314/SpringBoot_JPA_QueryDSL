package com.zx.demo.core.modules.user.repository;

import com.zx.demo.core.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Long>, QuerydslPredicateExecutor<User> {

}
