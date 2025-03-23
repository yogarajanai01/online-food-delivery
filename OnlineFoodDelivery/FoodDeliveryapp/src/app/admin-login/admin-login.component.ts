import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Menu } from '../menu';
import { MenuServiceService } from '../menu-service.service';
import { error } from 'console';
@Component({
  selector: 'app-admin-login',
  standalone: false,
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {
  constructor(private router: Router,private menuservices:MenuServiceService) {}

  loginRequest = {
    email: '',
    password: ''
  };


  email: string = ''; // User input for email
  password: string = ''; // User input for password
  message: string = '';

  adminUsername: string = 'admin'; // Admin username
  adminPassword: string = 'Yogi007'; // Admin password


  onLogin() {
  //   if (!this.loginRequest.email|| !this.loginRequest.password)
  //  {
  //     Swal.fire('Error', 'Please fill in all fields', 'error');
  //     return;
  //   }
 // Check for Admin credentials
 if (this.email===this.adminUsername && this.password===this.adminPassword ) {
  
  Swal.fire({
    title: 'Admin Login Successful!',
    text: 'Welcome Admin!',
    icon: 'success',
    confirmButtonText: 'OK'
  });
  this.router.navigate(['/admin-home']); // Navigate to admin dashboard
  return;
}

}
}

