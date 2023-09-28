import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTableHeaderComponent } from './app-table-header.component';

describe('AppTableHeaderComponent', () => {
  let component: AppTableHeaderComponent;
  let fixture: ComponentFixture<AppTableHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppTableHeaderComponent]
    });
    fixture = TestBed.createComponent(AppTableHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
