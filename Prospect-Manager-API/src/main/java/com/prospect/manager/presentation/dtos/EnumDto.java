package com.prospect.manager.presentation.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnumDto {

    private final String name;

    private final String description;

    public EnumDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
