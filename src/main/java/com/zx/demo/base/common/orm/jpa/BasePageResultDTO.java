package com.zx.demo.base.common.orm.jpa;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class BasePageResultDTO<T> {
    private Long count;

    private List<T> list;

    public BasePageResultDTO() {
    }

    public BasePageResultDTO(Page<T> page) {
        this.count = page.getTotalElements();
        this.list = page.getContent();
    }

    public BasePageResultDTO(long count, List<T> list) {
        this.count = count;
        this.list = list;
    }

    public static <T> BasePageResultDTO<T> from(Page<?> pageList,Class<T> clazz){
        ModelMapper modelMapper=new ModelMapper();
        List<T> list=pageList.getContent().stream().map(e->modelMapper.map(e,clazz))
                .collect(Collectors.toList());
        return new BasePageResultDTO<>(pageList.getTotalElements(),list);
    }

}
