import { Component } from '@angular/core';
import { Menu } from '../menu';
import { MenuServiceService } from '../menu-service.service';
import Swal from 'sweetalert2';
import { FormsModule, NgForm } from '@angular/forms';
import { response } from 'express';
@Component({
  selector: 'app-add-menu',
  standalone: false,
  templateUrl: './add-menu.component.html',
  styleUrl: './add-menu.component.css'
})
export class AddMenuComponent {
 Menu = {
    id: 0,
    name: '',
    price: 0,
    restaurant:{id:0}
  };

  constructor(private menuService:MenuServiceService ) {}

  addMenu() {
    this.menuService.addMenus(this.Menu).subscribe({
      next: (response) => {
        Swal.fire('Success', 'Menu added successfully!', 'success');
        console.log('Menu added successfully:', response);
      },
      error: (error) => {
        Swal.fire('Error', 'Failed to add menu!', 'error');
        console.error('Error adding menu:', error);
      }
    });
  }

}
