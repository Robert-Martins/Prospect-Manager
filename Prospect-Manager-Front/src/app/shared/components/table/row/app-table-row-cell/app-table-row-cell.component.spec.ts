import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTableRowCellComponent } from './app-table-row-cell.component';

describe('AppTableRowCellComponent', () => {
  let component: AppTableRowCellComponent;
  let fixture: ComponentFixture<AppTableRowCellComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppTableRowCellComponent]
    });
    fixture = TestBed.createComponent(AppTableRowCellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
