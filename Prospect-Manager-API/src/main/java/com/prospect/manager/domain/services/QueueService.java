package com.prospect.manager.domain.services;

import com.prospect.manager.domain.repositories.QueueItemRepository;
import com.prospect.manager.presentation.services.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService implements IQueueService {

    @Autowired
    private QueueItemRepository queueItemRepository;

}
