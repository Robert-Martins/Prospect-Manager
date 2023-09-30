import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppTableComponent } from './app-table.component';
import { AppTableHeaderComponent } from './header/app-table-header.component';
import { AppTableHeaderCellComponent } from './header/app-table-header-cell/app-table-header-cell.component';
import { AppTableRowComponent } from './row/app-table-row.component';
import { AppTableRowCellComponent } from './row/app-table-row-cell/app-table-row-cell.component';
import { SharedModule } from '../../shared.module';



@NgModule({
  declarations: [
    AppTableComponent,
    AppTableHeaderComponent,
    AppTableHeaderCellComponent,
    AppTableRowComponent,
    AppTableRowCellComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    AppTableComponent,
    AppTableHeaderComponent,
    AppTableHeaderCellComponent,
    AppTableRowComponent,
    AppTableRowCellComponent
  ]
})
export class TableModule { }
