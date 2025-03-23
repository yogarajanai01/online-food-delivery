import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { UserViewmenuComponent } from './user-viewmenu/user-viewmenu.component';
import { UserPlaceorderComponent } from './user-placeorder/user-placeorder.component';
import { UserVieworderComponent } from './user-vieworder/user-vieworder.component';
const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path: 'admin-login',component:AdminLoginComponent},
  {path: 'user-login',component:UserLoginComponent},
  {path: 'user-register',component:UserRegisterComponent},
  {path: 'admin-home', component:AdminHomeComponent},
  {path: 'user-home',component:UserHomeComponent},
  {path: 'admin-header',component:AdminHeaderComponent},
  {path:'add-menu',component:AddMenuComponent},
  {path:'add-restaurant',component:AddRestaurantComponent},
  {path:'user-viewmenu',component:UserViewmenuComponent},
  {path:'user-placeorder',component:UserPlaceorderComponent},
  {path:'user-vieworder',component:UserVieworderComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
