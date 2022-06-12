package com.example.ss8_form_validation.converter;

import org.springframework.core.convert.converter.Converter;

public class NumberConverter implements Converter<String,Integer> {
    @Override
    public Integer convert(String source) {
        try{
            return Integer.valueOf(source);
        }
        catch (Exception e)
        {
            return -1;
        }

    }
}
