import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderRequest } from './order-request';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080'; // adjust if needed

  constructor(private http: HttpClient) {}

  // placeOrder(userId: number, orderRequest: OrderRequest): Observable<any> {
  //   return this.http.post(`${this.baseUrl}/place-order/${userId}`, orderRequest);
  // }
  // order.service.ts
placeOrder(userId: number, orderRequest: OrderRequest) {
  return this.http.post(`http://localhost:8080/order/${userId}`, orderRequest, { responseType: 'text' });
}

 
}
