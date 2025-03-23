import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-user-register',
  standalone: false,
  templateUrl: './user-register.component.html',
  styleUrl: './user-register.component.css'
})
export class UserRegisterComponent {
  user={
    name: '',
    email: '',
    password: '',
    mobileno:'',
    address:''
  };
  constructor(private http: HttpClient, private router: Router) {}
 
  register() {
    if (!this.user.name || !this.user.email || !this.user.password || !this.user.mobileno || !this.user.address) {
      Swal.fire('Error', 'All fields are required!', 'error');
      return;
    }
   this.http.post('http://localhost:8080/register', this.user).subscribe(
     (response: any) => {
       Swal.fire('Success', 'Registration successful! Please log in.', 'success').then(() => {
         // Navigate to login page after successful registration
         this.router.navigate(['/user-login']);
       });
     },
     (error:any) => {
       Swal.fire('Error', 'User already exists or invalid input!', 'error');
     }
   );
 }
 
 }
 
