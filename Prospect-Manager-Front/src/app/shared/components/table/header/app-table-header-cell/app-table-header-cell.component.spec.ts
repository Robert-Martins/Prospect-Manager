import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTableHeaderCellComponent } from './app-table-header-cell.component';

describe('AppTableHeaderCellComponent', () => {
  let component: AppTableHeaderCellComponent;
  let fixture: ComponentFixture<AppTableHeaderCellComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppTableHeaderCellComponent]
    });
    fixture = TestBed.createComponent(AppTableHeaderCellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
