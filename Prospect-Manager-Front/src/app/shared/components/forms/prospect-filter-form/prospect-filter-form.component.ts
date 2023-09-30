import { Component, Input, EventEmitter, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { EnumDto } from 'src/app/core/models/enum.model';

@Component({
  selector: 'prospect-filter-form',
  templateUrl: './prospect-filter-form.component.html',
  styleUrls: ['./prospect-filter-form.component.scss']
})
export class ProspectFilterFormComponent {

  @Input()
  public formGroup: FormGroup;

  @Input()
  public status: EnumDto[] = [];

  @Output()
  public onApply: EventEmitter<void> = new EventEmitter<void>();

  @Output()
  public onClear: EventEmitter<void> = new EventEmitter<void>();

}
