import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserVieworderComponent } from './user-vieworder.component';

describe('UserVieworderComponent', () => {
  let component: UserVieworderComponent;
  let fixture: ComponentFixture<UserVieworderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserVieworderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserVieworderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
