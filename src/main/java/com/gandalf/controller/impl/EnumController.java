package com.gandalf.controller.impl;

import com.gandalf.service.impl.EnumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enums")
@RequiredArgsConstructor
public class EnumController {

    private final EnumService enumService;

    @GetMapping("/{enumName}")
    public List<Map<String, String>> getEnum(@PathVariable String enumName) throws ClassNotFoundException {
        return enumService.getEnumValues(enumName);
    }
}

