package com.prospect.manager.presentation.controllers;

import com.prospect.manager.presentation.dtos.EnumDto;
import com.prospect.manager.presentation.services.IGenericEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ApplicationController {

    @Autowired
    private IGenericEnumService genericEnumService;

    @GetMapping(value = "/enum/{enumName}")
    @ResponseStatus(HttpStatus.OK)
    public List<EnumDto> loadEnum(@PathVariable(name = "enumName") String enumName) {
        return this.genericEnumService.loadEnum(enumName);
    }

}
