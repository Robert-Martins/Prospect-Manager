package com.prospect.manager.infrastructure.utils;

import com.prospect.manager.domain.models.QueueItem;

public class ComparatorUtils {

    public static Integer compareQueueItemsByUpdatedAt(QueueItem first, QueueItem second) {
        return first.getProspect().getUpdatedAt().compareTo(second.getProspect().getUpdatedAt());
    }

}
