import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogElementsDetailsDialogComponent } from './dialog-elements-details-dialog.component';

describe('DialogElementsDetailsDialogComponent', () => {
  let component: DialogElementsDetailsDialogComponent;
  let fixture: ComponentFixture<DialogElementsDetailsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogElementsDetailsDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogElementsDetailsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
