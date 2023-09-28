import { Prospect } from "./prospect.model";
import { QueueItem } from "./queue-item.model";

export class Queue {

    public size: number;
    public first: Prospect;
    public queueItems: QueueItem[];

    constructor(
        size: number = null,
        first: Prospect = null,
        queueItems: QueueItem[] = []
    ) {
        this.size = size;
        this.first = first;
        this.queueItems = queueItems;
    }

}