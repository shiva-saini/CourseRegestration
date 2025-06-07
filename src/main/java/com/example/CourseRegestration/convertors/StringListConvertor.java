package com.example.CourseRegestration.convertors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConvertor implements AttributeConverter<List<String>, String> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        try {
            return mapper.writeValueAsString(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String json) {
        try {
            return Arrays.asList(mapper.readValue(json, String[].class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
