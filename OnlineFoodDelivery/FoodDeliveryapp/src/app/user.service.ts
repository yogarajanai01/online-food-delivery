import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private currentUser: any = null;

  constructor() {
   
    if(typeof window !== 'undefined' && localStorage)
    {
      const savedUser = localStorage.getItem('currentUser');
    if (savedUser) {
      this.currentUser = JSON.parse(savedUser); // Load from local storage
    }
    }

  }

  setCurrentUser(user: any) {
    this.currentUser = user;
    if(typeof window !== 'undefined' && localStorage){
      localStorage.setItem('currentUser', JSON.stringify(user)); // Save persistently
    }
   }

  getUser() {
    return this.currentUser;
  }

  isLoggedIn(): boolean {
    return this.currentUser !== null;
  }

  logout() {
    this.currentUser = null;
    localStorage.removeItem('currentUser');
  }
 
}
