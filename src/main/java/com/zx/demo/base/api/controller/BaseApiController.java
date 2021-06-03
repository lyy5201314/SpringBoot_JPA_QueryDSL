package com.zx.demo.base.api.controller;

import com.zx.demo.base.common.orm.jpa.BasePageResultDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseApiController<T> {
    @Autowired
    protected ModelMapper modelMapper;

    protected <D> D toDTO(T source,Class<D> destinationType){
        return modelMapper.map(source,destinationType);
    }

    protected <D> BasePageResultDTO<D> toDTO(Page<T> source, Class<D> destinationType){
        List<D> list=source.getContent().stream().map(e->modelMapper.map(e,destinationType)).collect(Collectors.toList());
        return new BasePageResultDTO<>(source.getTotalElements(),list);
    }

    protected T toModel(Object source,Class<T> destinationType){
        return modelMapper.map(source,destinationType);
    }
}
