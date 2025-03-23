import { Component } from '@angular/core';
import { RestuarantServicesService } from '../restuarant-services.service';
import Swal from 'sweetalert2';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-restaurant',
  standalone: false,
  templateUrl: './add-restaurant.component.html',
  styleUrl: './add-restaurant.component.css'
})
export class AddRestaurantComponent {
  restaurant = {
    id: 0,
    name: '',
    address: ''
  };

  constructor(private restuarantService: RestuarantServicesService) {}

  onSubmit(form: NgForm) {
    if (form.invalid) {
      Swal.fire({
        title: 'Error!',
        text: 'Please fill in all fields!',
        icon: 'error',
        confirmButtonText: 'OK'
      });
      return;
    }

    this.restuarantService.saveRestaurant(this.restaurant).subscribe({
      next: () => {
        Swal.fire({
          title: 'Success!',
          text: 'Restaurant Added Successfully!',
          icon: 'success',
          confirmButtonText: 'OK'
        });
        form.resetForm(); // Reset form after success
      },
      error: () => {
        Swal.fire({
          title: 'Error!',
          text: 'Failed to Add Restaurant!',
          icon: 'error',
          confirmButtonText: 'OK'
        });
      }
    });
  }

}

