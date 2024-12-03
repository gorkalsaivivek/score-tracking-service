package com.cricket.scoretrackingservice.utils;

import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Component
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return dbData != null && dbData == 1;
    }
}
