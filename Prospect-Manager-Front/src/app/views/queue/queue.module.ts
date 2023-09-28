import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueueViewComponent } from './queue-view/queue-view.component';



@NgModule({
  declarations: [
    QueueViewComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    QueueViewComponent
  ]
})
export class QueueModule { }
