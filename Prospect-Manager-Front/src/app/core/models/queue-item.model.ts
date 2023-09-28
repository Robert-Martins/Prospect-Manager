export class QueueItem {

    public name: string;
    public createdAt: Date;
    public updatedAt: Date;

    constructor(
        name: string = null,
        createdAt: Date = null,
        updatedAt: Date = null
    ) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}