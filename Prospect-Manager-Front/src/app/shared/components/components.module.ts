import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { TableModule } from './table/table.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { DialogsModule } from './dialogs/dialogs.module';
import { RouterModule } from '@angular/router';
import { CardsModule } from './cards/cards.module';
import { FormsModule } from './forms/forms.module';
import { DirectivesModule } from '../directives/directives.module';



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
    CardsModule,
    FormsModule,
    RouterModule,
    DirectivesModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    DialogsModule,
    TableModule,
    CardsModule,
    FormsModule
  ]
})
export class ComponentsModule { }
