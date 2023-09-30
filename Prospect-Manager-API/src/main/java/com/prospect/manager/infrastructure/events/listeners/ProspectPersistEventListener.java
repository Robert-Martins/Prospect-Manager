package com.prospect.manager.infrastructure.events.listeners;

import com.prospect.manager.infrastructure.events.ProspectPersistEvent;
import com.prospect.manager.presentation.services.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProspectPersistEventListener implements ApplicationListener<ProspectPersistEvent> {

    @Autowired
    private IQueueService queueService;

    @Override
    public void onApplicationEvent(ProspectPersistEvent event) {
        switch (event.getType()) {
            case CREATE -> this.queueService.insertLast(event.getProspectId());
            case UPDATE -> this.queueService.onItemUpdate(event.getProspectId());
            case DELETE -> this.queueService.onItemDelete(event.getProspectId());
        }
    }

}
