export class AppListItemContext<T> {

    public $implicit: T;
    public index: number;

    constructor($implicit: T, index: number) {
        this.$implicit = $implicit;
        this.index = index;
    }
     
}