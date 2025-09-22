package com.gandalf.service.impl;

import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class EnumService {

    private static final String ENUM_PACKAGE = "com.gandalf.enums"; // enumların bulunduğu package

    public List<Map<String, String>> getEnumValues(String enumName) throws ClassNotFoundException {
        Class<?> enumClass = Class.forName(ENUM_PACKAGE + "." + enumName);

        if (!enumClass.isEnum()) {
            throw new IllegalArgumentException(enumName + " bir enum değil!");
        }

        return Arrays.stream(enumClass.getEnumConstants())
                .map(constant -> {
                    try {
                        String name = ((Enum<?>) constant).name();

                        Method getLabelMethod = enumClass.getMethod("getLabel");
                        String label = (String) getLabelMethod.invoke(constant);

                        return Map.of("name", name, "label", label);
                    } catch (Exception e) {
                        throw new RuntimeException("Enum label okunamadı", e);
                    }
                })
                .toList();
    }
}

