import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueueViewComponent } from './queue-view/queue-view.component';
import { QueueRoutingModule } from './queue-routing.module';



@NgModule({
  declarations: [
    QueueViewComponent
  ],
  imports: [
    CommonModule,
    QueueRoutingModule
  ]
})
export class QueueModule { }
