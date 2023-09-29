import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProspectsFormComponent } from './prospects-form/prospects-form.component';
import { ProspectsListComponent } from './prospects-list/prospects-list.component';

const routes: Routes = [
  {
    path: '',
    component: ProspectsListComponent
  },
  {
    path: 'form/:id',
    component: ProspectsFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProspectsRoutingModule { }