import { Directive, EmbeddedViewRef, Input, OnDestroy, TemplateRef, ViewContainerRef } from '@angular/core';
import AppDataSource from './models/data/data-source.model';
import { AppListItemContext } from './models/context/app-list-item-context.model';
import { Subscription } from 'rxjs';

@Directive({
  selector: '[appList]'
})
export class AppListDirective<T> implements OnDestroy {
  private appDataSource: AppDataSource<T>;
  private embeddedViewRefs: EmbeddedViewRef<AppListItemContext<T>>[] = [];
  private subscriptions: Array<Subscription> = [];

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainerRef: ViewContainerRef
  ) {}

  ngOnDestroy(): void {
    if(this.subscriptions.length > 0)
      this.subscriptions.forEach((current) => current.unsubscribe());
  }

  @Input()
  public set appListItemDef(data: AppDataSource<T>) {
    this.setDataSource(data);
    this.updateView();
  }

  public createEmbeddedView<T>(
    value: T,
    index: number
  ): EmbeddedViewRef<AppListItemContext<T>> {
    const context = new AppListItemContext<T>(value, index);
    return this.viewContainerRef.createEmbeddedView(
      this.templateRef,
      context,
      index
    );
  }

  private updateView(): void {
    this.embeddedViewRefs.forEach((view) => view.destroy());
    this.embeddedViewRefs = [];
    if (
      this.appDataSource?.data.length > 0 &&
      (this.appListItemDef || this.templateRef)
    ) {
      this.appDataSource?.data?.forEach((element, index) =>
        this.embeddedViewRefs.push(this.createEmbeddedView(element, index))
      );
    }
  }

  private setDataSource(data: AppDataSource<T> | T[]) {
    if (data instanceof AppDataSource) {
      this.appDataSource = data;
    } else {
      this.appDataSource = new AppDataSource(data);
    }
    if (this.appDataSource) {
      this.subscriptions.push(
        this.appDataSource?.onChange().subscribe(() => this.updateView())
      );
    }
  }

}