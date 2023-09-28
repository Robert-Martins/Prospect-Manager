export class EnumDto {

    public name: string;
    public description: string;

    constructor(
        name: string = null,
        description: string = null
    ) {
        this.name = name;
        this.description = description;
    }

}