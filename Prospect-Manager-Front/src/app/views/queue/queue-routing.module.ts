import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QueueViewComponent } from './queue-view/queue-view.component';

const routes: Routes = [
  {
    path: '',
    component: QueueViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QueueRoutingModule { }