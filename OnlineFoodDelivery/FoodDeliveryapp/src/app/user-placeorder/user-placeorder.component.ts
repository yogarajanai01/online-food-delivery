import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../menu-service.service';
import {Menu} from '../menu';
import Swal from 'sweetalert2';
import { OrderRequest } from '../order-request';
import { OrderService } from '../order.service';

import { Router } from '@angular/router';
@Component({
  selector: 'app-user-placeorder',
  standalone: false,
  templateUrl: './user-placeorder.component.html',
  styleUrl: './user-placeorder.component.css'
})
export class UserPlaceorderComponent {
  
  user: any;
  menuItems: Menu[] = [];
  selectedItemIds: number[] = [];
  totalPrice: number = 0;
  paymentMethod: string = '';

  constructor(
    private orderService: OrderService,
    private menuService: MenuServiceService
  ) {}

  // ngOnInit(): void {
  //   this.user = this.userService.getUser();
  //   this.fetchMenuItems();


  fetchMenuItems() {
    this.menuService.getAllMenuItems().subscribe({
      next: (data) => {
        this.menuItems = data;
      },
      error: (error) => {
        Swal.fire('Error', 'Failed to fetch menu items',error);
      }
    });
  }

  calculateTotal() {
    this.totalPrice = this.menuItems
      .filter(item => this.selectedItemIds.includes(item.id))
      .reduce((sum, item) => sum + item.price, 0);
  }

  onItemSelect(event:any) {
    const id = +event.target.value;
    if (event.target.checked) {
      this.selectedItemIds.push(id);
    } else {
      this.selectedItemIds = this.selectedItemIds.filter(itemId => itemId !== id);
    }
    this.calculateTotal();
  }

  placeOrder() {
    if (this.selectedItemIds.length === 0 || !this.paymentMethod) {
      Swal.fire('Error', 'Please select items and payment method!', 'error');
      return;
    }

    const orderRequest: OrderRequest = {
      menuItemIds: this.selectedItemIds,
      paymentMethod: this.paymentMethod
    };

    this.orderService.placeOrder(this.user.id, orderRequest).subscribe({
      next: () => {
        Swal.fire('Success', 'Order placed successfully!', 'success');
      },
      error: () => {
        Swal.fire('Error', 'Failed to place order', 'error');
      }
    });
  }
}  
  /*user: any;
  menuItems: Menu[] = [];
  selectedItem: any[] = [];
  totalPrice: number = 0;
  paymentMethod: string = '';

  foodName: string = '';
  foodPrice: number = 0;
  constructor(
    private userService: UserService,
    private orderService: OrderService,
    private menuService: MenuServiceService,
    private route:ActivatedRoute
  ) {}

  // ngOnInit(): void {
  //   this.user = this.userService.getUser();
  //   this.fetchMenuItems();
  // }

ngOnInit(): void {
  this.user = this.userService.getUser();
  console.log("User Data:", this.user); // Check in console
  this.fetchMenuItems();
}

  fetchMenuItems() {
    this.menuService.getAllMenuItems().subscribe({
      next: (data: Menu[]) => {
        this.menuItems = data;
      },
      error: () => {
        Swal.fire('Error', 'Failed to fetch menu items', 'error');
      }
    });
  }

  calculateTotal() {
    this.totalPrice = this.menuItems
      .filter(item => this.selectedItem.includes(item.id))
      .reduce((sum, item) => sum + item.price, 0);
  }

  onItemSelect(event: any, menu :any) {
    if (event.target.checked) {
      this.selectedItem.push(menu);
    } else {
      this.selectedItem = this.selectedItem.filter(item => item.name !== menu.name);
    }
    this.calculateTotal();
  }

  placeOrder() {
    if (this.selectedItem.length === 0 || !this.paymentMethod) {
      Swal.fire('Error', 'Please select items and payment method!', 'error');
      return;
    }

    const orderRequest: OrderRequest = {
      menuItemIds: this.selectedItem,
      paymentMethod: this.paymentMethod
    };

    this.orderService.placeOrder(this.user.id, orderRequest).subscribe({
      next: () => {
        Swal.fire('Success', 'Order placed successfully!', 'success');
      },
      error: () => {
        Swal.fire('Error', 'Failed to place order', 'error');
      }
    });
  }
}*/


