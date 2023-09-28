import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProspectsFormComponent } from './prospects-form/prospects-form.component';
import { ProspectsListComponent } from './prospects-list/prospects-list.component';



@NgModule({
  declarations: [
    ProspectsFormComponent,
    ProspectsListComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ProspectsFormComponent,
    ProspectsListComponent
  ]
})
export class ProspectsModule { }
