import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTableRowComponent } from './app-table-row.component';

describe('AppTableRowComponent', () => {
  let component: AppTableRowComponent;
  let fixture: ComponentFixture<AppTableRowComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppTableRowComponent]
    });
    fixture = TestBed.createComponent(AppTableRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
