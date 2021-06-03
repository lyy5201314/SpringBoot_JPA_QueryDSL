package com.zx.demo.core.modules.project.dto;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.zx.demo.core.modules.project.model.QProject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;



@Data
public class ProjectSearchDTO {

    private String id;

    private String name;

    private String address;

    private String schoolId;

    /**
     * 转换成检索谓词
     */
    public Predicate toPredicate() {
        BooleanBuilder where =new BooleanBuilder();
        if (!StringUtils.isEmpty(id)){
            where.and(QProject.project.id.eq(Long.valueOf(id)));
        }
        if (!StringUtils.isEmpty(name)){
            where.and(QProject.project.name.eq(name));
        }
        if (!StringUtils.isEmpty(address)){
            where.and(QProject.project.name.eq(address));
        }

        if (!StringUtils.isBlank(schoolId)){
            where.and(QProject.project.school.id.eq(Long.valueOf(schoolId)));
        }
        return where.getValue();
    }
}
