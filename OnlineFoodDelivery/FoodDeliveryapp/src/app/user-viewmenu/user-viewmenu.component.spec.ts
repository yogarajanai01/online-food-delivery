import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewmenuComponent } from './user-viewmenu.component';

describe('UserViewmenuComponent', () => {
  let component: UserViewmenuComponent;
  let fixture: ComponentFixture<UserViewmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserViewmenuComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserViewmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
