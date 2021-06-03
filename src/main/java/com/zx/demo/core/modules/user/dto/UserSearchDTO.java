package com.zx.demo.core.modules.user.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.zx.demo.core.modules.user.model.QUser;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class UserSearchDTO {

    private String id;
    private String name;
    private String password;

    public Predicate toPredicate() {
        BooleanBuilder where =new BooleanBuilder();
        if (!StringUtils.isEmpty(id)){
            where.and(QUser.user.id.eq(Long.valueOf(id)));
        }
        if (!StringUtils.isEmpty(name)){
            where.and(QUser.user.name.eq(name));
        }
        if (!StringUtils.isEmpty(password)){
            where.and(QUser.user.name.eq(password));
        }
        return where.getValue();
    }
}
