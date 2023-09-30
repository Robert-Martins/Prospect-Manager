import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueueViewComponent } from './queue-view/queue-view.component';
import { QueueRoutingModule } from './queue-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatTableModule } from '@angular/material/table';



@NgModule({
  declarations: [
    QueueViewComponent
  ],
  imports: [
    CommonModule,
    QueueRoutingModule,
    SharedModule,
    MatTableModule
  ]
})
export class QueueModule { }
