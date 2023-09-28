export class Person {

    public id: string;
    public name: string;
    public cpf: string;
    public email: string;
    public mcc: number;

    constructor(
        id: string = null,
        name: string = null,
        cpf: string = null,
        email: string = null,
        mcc: number = null
    ) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.mcc = mcc;
    }

}