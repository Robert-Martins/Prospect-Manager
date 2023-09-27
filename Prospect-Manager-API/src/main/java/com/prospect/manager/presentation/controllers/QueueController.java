package com.prospect.manager.presentation.controllers;

import com.prospect.manager.presentation.dtos.QueueDto;
import com.prospect.manager.presentation.services.IQueueService;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private IQueueService queueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertLast(@RequestBody @NotNull ObjectId prospectId) {
        this.queueService.insertLast(prospectId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public QueueDto getQueue() {
        return this.queueService.getQueue();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public QueueDto removeFirst() {
        return this.queueService.removeFirst();
    }

}
