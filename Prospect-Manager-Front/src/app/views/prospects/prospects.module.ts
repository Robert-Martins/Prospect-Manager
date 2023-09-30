import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProspectsFormComponent } from './prospects-form/prospects-form.component';
import { ProspectsListComponent } from './prospects-list/prospects-list.component';
import { ProspectsRoutingModule } from './prospects-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatTableModule } from '@angular/material/table';



@NgModule({
  declarations: [
    ProspectsFormComponent,
    ProspectsListComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ProspectsRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatTableModule
  ]
})
export class ProspectsModule { }
