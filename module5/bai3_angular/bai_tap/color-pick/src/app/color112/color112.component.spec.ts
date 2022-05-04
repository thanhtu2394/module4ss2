import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Color112Component } from './color112.component';

describe('Color112Component', () => {
  let component: Color112Component;
  let fixture: ComponentFixture<Color112Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Color112Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Color112Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
