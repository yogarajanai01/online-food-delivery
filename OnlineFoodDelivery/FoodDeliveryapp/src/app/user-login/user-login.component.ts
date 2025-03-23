import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import Swal from 'sweetalert2';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  standalone: false,
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent {
  
/*  loginRequest = {
    email: '',
    password: ''
  };
  errorMessage: string = '';

  constructor(
    private http: HttpClient,
    private router: Router,
    private userService: UserService
  ) {}

  onSubmit() {
    if (!this.loginRequest.email || !this.loginRequest.password) {
      Swal.fire('Error', 'Please fill in all fields', 'error');
      return;
    }
  
    this.http.post('http://localhost:8080/login' ,this.loginRequest,{responseType : 'text'})
      .subscribe({
        next: (response) => {
          console.log(response); // Full user object
          const parsedResponse = JSON.parse(response);

          // Set ONLY the fields you need (including phone_no)
          this.userService.setCurrentUser({
            id: parsedResponse.id,
            name: parsedResponse.name,
            address: parsedResponse.address,
            phone_no: parsedResponse.mobileno  // IMPORTANT
          });
          
          Swal.fire('Success', response, 'success').then(() => {
            this.router.navigate(['/user-home']); // or wherever
          });
        },
        error: (err: { status: number; }) => {
          console.error(err);
          if (err.status === 401) {
            Swal.fire('Error', 'Invalid email or password', 'error');
          } else {
            Swal.fire('Error', 'An error occurred. Please try again later.', 'error');
          }
        }
      });
}*/

  loginRequest = {
    email: '',
    password:''
  };

  errorMessage: string='';

  constructor(private http:HttpClient,private router:Router,private userservice:UserService){}
  onSubmit(){
     // Validate inputs
     if (!this.loginRequest.email || !this.loginRequest.password)
      {
       Swal.fire('Error', 'Please fill in all fields', 'error');
       return;
     }
   
  // Clear error messages and make HTTP POST request
  this.http.post('http://localhost:8080/login', this.loginRequest, { responseType: 'text' })
  .subscribe({
    next: (response:any) => {
      console.log(response);
      // Show success alert
      Swal.fire('Success', 'Login successful!', 'success').then(() => {
        // Navigate to the home page
        this.router.navigate(['/user-home']);
      });
    },
    error: (error) => {
      console.error(error);
      // Show error alerts based on status
      if (error.status === 401) {
        Swal.fire('Error', 'Invalid email or password', 'error');
      } else {
        Swal.fire('Error', 'An error occurred. Please try again later.', 'error');
      }
    }
  });
 }
 
 }
  
