package com.prospect.manager.presentation.services;

import com.prospect.manager.presentation.dtos.QueueDto;
import org.bson.types.ObjectId;

public interface IQueueService {

    void insertLast(ObjectId prospectId);

    QueueDto getQueue();

    void onItemUpdate(ObjectId prospectId);

    QueueDto removeFirst();

}
