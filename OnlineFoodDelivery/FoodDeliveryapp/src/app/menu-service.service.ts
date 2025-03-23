import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable , of } from 'rxjs';
import { Menu } from './menu';
@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {
    private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Add a new menu item
  addMenus(menuData: Menu): Observable<Menu> {
    console.log('sending Api request:',menuData);
    return this.http.post<Menu>(`${this.api}/save/menu`, menuData);
  }

  // Get all menu items
  getAllMenuItems(): Observable<Menu[]> {
    return this.http.get<Menu[]>(`${this.api}/get/menu`);
  }

  // Update menu item by ID
  updateMenu(id: number, updatedData: Menu): Observable<Menu> {
    return this.http.put<Menu>(`${this.api}/update/menu/${id}`, updatedData);
  }

  // Delete menu item by ID
  deleteMenu(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/delete/menu/${id}`);
  }
}


  