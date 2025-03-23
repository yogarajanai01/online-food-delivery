import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Restaurant } from './restaurant';
@Injectable({
  providedIn: 'root'
})
export class RestuarantServicesService {
private api ='http://localhost:8080';
  constructor(private http: HttpClient) {}

  saveRestaurant(restaurantData: any): Observable<any>{
    return this.http.post(`${this.api}/save/restaurant`,restaurantData);
  }

  getRestaurant():Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(`${this.api}/get/restaurant`);
  }
}
