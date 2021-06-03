package com.zx.demo.base.model.mapper;

import com.zx.demo.base.common.date.DateUtil;
import org.modelmapper.AbstractConverter;
import org.modelmapper.internal.Errors;

import java.text.ParseException;
import java.util.Date;


public class StringDateConverter extends AbstractConverter<String, Date> {

    @Override
    protected Date convert(String source) {
        try {
            return DateUtil.parse(source);
        } catch (ParseException e) {
            throw new Errors().addMessage(
                    "String must be in format [yyyy-MM-dd] or [yyyy-MM-dd hh:mm:ss.SSS] to Date")
                    .toMappingException();
        }
    }
}
