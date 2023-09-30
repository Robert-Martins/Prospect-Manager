import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppButtonDirective } from './app-button.directive';
import { AppListDirective } from './app-list.directive';



@NgModule({
  declarations: [
    AppButtonDirective,
    AppListDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    AppButtonDirective,
    AppListDirective
  ]
})
export class DirectivesModule { }
