package com.zx.demo.api.common.aspect;

import com.zx.demo.core.common.utils.ExaminationUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ControllerAspect {

    @Before("execution(* com.zx.demo.api.modules.*.controller.*Controller.*(..))")
    public void beforeMethod(){
        ExaminationUtil.start();
    }

    @After("execution(* com.zx.demo.api.modules.*.controller.*Controller.*(..))")
    public void afterMethod(){
        ExaminationUtil.end();
    }
}
