import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProspectsFormComponent } from './prospects-form/prospects-form.component';
import { ProspectsListComponent } from './prospects-list/prospects-list.component';
import { ProspectsRoutingModule } from './prospects-routing.module';



@NgModule({
  declarations: [
    ProspectsFormComponent,
    ProspectsListComponent
  ],
  imports: [
    CommonModule,
    ProspectsRoutingModule
  ]
})
export class ProspectsModule { }
