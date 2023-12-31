package com.prospect.manager.domain.models;

import com.prospect.manager.infrastructure.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "queue")
public class QueueItem extends BaseEntity {

    @DBRef
    private Prospect prospect;

    private ObjectId next;

    public QueueItem(Prospect prospect) {
        this.prospect = prospect;
    }

    public void clearNext() {
        this.next = null;
    }

    public Boolean hasNext() {
        return this.getNext() != null;
    }

}
