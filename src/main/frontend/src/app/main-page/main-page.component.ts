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
    userLoggedIn: boolean;


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

    openOfferDialog() {
      if(this.userLoggedIn){
        this.dialog.open(OfferDialogComponent, {
            width: '300px'
        });
      }else{
        this.alerts.setMessage('Firt Login or Logup', 'error');
        this.onActivate();
      }
    }

    openSingInDialog() {
      this.dialog.open(SingInComponent, {
        width: '450px'
      })
    }

    // This is for distinguish users who are logged in and who are not.
    checkIfUserLoggedIn() {
      this.http.get('http://localhost:8080/login').subscribe(response => {
        this.userLoggedIn = true;
        alert('Success');
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

}
