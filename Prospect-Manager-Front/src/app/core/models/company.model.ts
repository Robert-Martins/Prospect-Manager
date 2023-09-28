import { Person } from "./person.model";

export class Company {

    public id: string;
    public companyName: string;
    public cnpj: string;
    public mcc: number;
    public contact: Person;

    constructor(
        id: string = null,
        companyName: string = null,
        cnpj: string = null,
        mcc: number = null,
        contact: Person = null
    ) {
        this.id = id;
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.mcc = mcc;
        this.contact = contact;
    }

}