package com.prospect.manager.presentation.services;

import com.prospect.manager.presentation.dtos.EnumDto;

import java.util.List;

public interface IGenericEnumService {

    List<EnumDto> loadEnum(String enumName);

}
