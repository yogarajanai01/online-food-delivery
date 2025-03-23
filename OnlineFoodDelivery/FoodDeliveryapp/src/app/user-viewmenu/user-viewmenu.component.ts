import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { MenuServiceService } from '../menu-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-viewmenu',
  standalone: false,
  templateUrl: './user-viewmenu.component.html',
  styleUrl: './user-viewmenu.component.css'
})
export class UserViewmenuComponent implements OnInit{

menuItems: Menu[] = [];
user: any;
menu: any;

constructor(private router: Router, private menuservice: MenuServiceService) {}

ngOnInit(): void {
  this.fetchMenuItems();
}

// ✅ Fetch menu items from backend
fetchMenuItems() {
  this.menuservice.getAllMenuItems().subscribe(
    (data) => {
      console.log("Fetched Menu items :",data);
      this.menuItems = data;
    },
    (error) => {
      console.error('Error fetching menu items:', error);
    }
  );
}
placeOrder(item: any) {
  this.router.navigate(['/user-placeorder'], { queryParams: { food: item.name, price: item.price } });

}
}

