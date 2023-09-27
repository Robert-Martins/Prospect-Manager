package com.prospect.manager.presentation.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueueDto {

    private Integer size;

    private ProspectDto first;

    private List<QueueItemDto> queueItems;

}
