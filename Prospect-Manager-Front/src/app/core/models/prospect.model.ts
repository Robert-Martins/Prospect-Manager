import { Company } from "./company.model";
import { Person } from "./person.model";

export class Prospect {

    public id: string;
    public status: string;
    public analyzedAt?: Date;
    public naturalPerson: boolean;
    public person?: Person;
    public company?: Company
    public createdAt: Date;

    constructor(
        id: string = null,
        status: string = null,
        analyzedAt: Date = null,
        naturalPerson: boolean = null,
        person: Person = null,
        company: Company = null,
        createdAt: Date = null
    ) {
        this.id = id;
        this.status = status;
        this.analyzedAt = analyzedAt;
        this.naturalPerson = naturalPerson;
        this.person = person;
        this.company = company;
        this.createdAt = createdAt;
    }

}