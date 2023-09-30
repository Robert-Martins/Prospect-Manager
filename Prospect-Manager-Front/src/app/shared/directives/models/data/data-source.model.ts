import { Observable, Subject } from "rxjs";

export default class AppDataSource<T> {

    private initialData: T[];
    private change: Subject<void> = new Subject();

    constructor(data: T[]) {
        this.initialData = data;
    }

    public get data(): T[] {
        return this.initialData || [];
    }

    public setData(data: T[]) {
        this.initialData = data;
    }

    public onChange(): Observable<void> {
        return this.change.asObservable();
    }

}