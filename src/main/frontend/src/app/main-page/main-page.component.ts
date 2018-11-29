import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material";
import {OfferDialogComponent} from "./offer-dialog/offer-dialog.component";
import {SingInComponent} from "./sing-in-up/sing-in.component";
import {AlertsService} from "angular-alert-module";

@Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html',
    styleUrls: ['./static/css/bootstrap/bootstrap.min.css', './main-page.component.css']
})

export class MainPageComponent implements OnInit {
    result;
    userLoggedIn: boolean = false;


    constructor(private http: HttpClient, private dialog: MatDialog,
                private alerts: AlertsService){
    }

    ngOnInit() {
        this.getAllOffers();
        this.checkIfUserLoggedIn();
    }

    search(data) {
        this.http.post('http://localhost:8080/search', data
        ).subscribe(
            res => {
                console.log('Passing the json is done');
                this.result = res;
                console.log(this.result);
            },
            err => {
                alert('Please fill out all fields');
            }
        );
    }

    getAllOffers() {
        this.http.get('http://localhost:8080/data').subscribe((data) => this.result = data, error1 => {
            console.log(error1)
        });
        console.log(this.result);
    }

    openOfferDialog(walkingTourId) {
      if(this.userLoggedIn){
        this.dialog.open(OfferDialogComponent, {
            width: '300px',
            data : walkingTourId
        });
      }else{
        this.alerts.setMessage('First Login or SignUp', 'error');
        this.onActivate();
      }
    }

    openSingInDialog() {
      this.dialog.open(SingInComponent, {
        width: '450px',
        data : {}
      })
    }

    // This is for distinguish users who are logged in and who are not.
    checkIfUserLoggedIn() {
      this.http.get('http://localhost:8080/login').subscribe(response => {
        this.userLoggedIn = true;
      },
        error => {
        this.userLoggedIn = false;
        })
    }

    onActivate() {
      let scrollToTop = window.setInterval(() => {
        let pos = window.pageYOffset;
        if (pos > 0) {
          window.scrollTo(0, pos - 20); // how far to scroll on each step
        } else {
          window.clearInterval(scrollToTop);
        }
      }, 16);
    }

    logOut(){
      this.http.get('http://localhost:8080/logout').subscribe( success => {
        console.log('log our should work');
      },
        error1 => {
        console.log('Log out not working');
        });
      this.checkIfUserLoggedIn();
    }

}
