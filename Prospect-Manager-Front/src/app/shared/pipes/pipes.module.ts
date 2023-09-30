import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DateformatPipe } from './dateformat.pipe';
import { TaxIdPipe } from './tax-id.pipe';
import { NamecasePipe } from './namecase.pipe';



@NgModule({
  declarations: [
    DateformatPipe,
    TaxIdPipe,
    NamecasePipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    DateformatPipe,
    TaxIdPipe,
    NamecasePipe
  ]
})
export class PipesModule { }
