package com.zx.demo.base.model.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Date;


public class ModelMapperUtil {

    public static ModelMapper createModelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.createTypeMap(String.class, Date.class);
        modelMapper.addConverter(new StringDateConverter());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
