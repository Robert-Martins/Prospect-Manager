import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProspectAnalysisCardComponent } from './prospect-analysis-card/prospect-analysis-card.component';



@NgModule({
  declarations: [
    ProspectAnalysisCardComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ProspectAnalysisCardComponent
  ]
})
export class CardsModule { }
