package com.prospect.manager.infrastructure.events;

import com.prospect.manager.infrastructure.enums.PersistType;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationEvent;

@Getter
public class ProspectPersistEvent extends ApplicationEvent {

    private final PersistType type;

    private final ObjectId prospectId;

    public ProspectPersistEvent(Object source, PersistType type, ObjectId prospectId) {
        super(source);
        this.type = type;
        this.prospectId = prospectId;
    }

}
