import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TableModule } from './table/table.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { DialogsModule } from './dialogs/dialogs.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    DialogsModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    TableModule,
    SidebarComponent,
    DialogsModule
  ]
})
export class ComponentsModule { }
