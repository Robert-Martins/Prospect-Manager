import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Input()
  public isSidebarOpen: boolean;

  @Output()
  public changeSidebarState: EventEmitter<void> = new EventEmitter();

}
