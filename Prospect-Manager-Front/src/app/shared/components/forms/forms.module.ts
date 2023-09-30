import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonFormComponent } from './person-form/person-form.component';
import { CompanyFormComponent } from './company-form/company-form.component';
import { ReactiveFormsModule, FormsModule as AngularFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { ProspectFilterFormComponent } from './prospect-filter-form/prospect-filter-form.component';
import { MatNativeDateModule } from '@angular/material/core';



@NgModule({
  declarations: [
    PersonFormComponent,
    CompanyFormComponent,
    ProspectFilterFormComponent
  ],
  imports: [
    CommonModule,
    AngularFormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatDatepickerModule,
    MatSelectModule,
    MatNativeDateModule
  ],
  exports: [
    PersonFormComponent,
    CompanyFormComponent,
    ProspectFilterFormComponent
  ]
})
export class FormsModule { }
