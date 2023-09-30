package com.prospect.manager.presentation.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class QueueItemDto {

    private String name;

    private Date createdAt;

    private Date updatedAt;

}
