package com.zx.demo.core;

import com.zx.demo.base.model.mapper.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {CoreConfig.class})
public class CoreConfig {

    @Bean
    public ModelMapper modelMapper(){
        return ModelMapperUtil.createModelMapper();
    }
}
