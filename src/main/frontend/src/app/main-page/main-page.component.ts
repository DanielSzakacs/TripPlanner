import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material";
import {OfferDialogComponent} from "./offer-dialog/offer-dialog.component";
import {SingInComponent} from "./sing-in-up/sing-in.component";

@Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html',
    styleUrls: ['./static/css/bootstrap/bootstrap.min.css', './main-page.component.css']
})

export class MainPageComponent implements OnInit {
    result;

    constructor(private http: HttpClient,
                private dialog: MatDialog) {
    }

    ngOnInit() {
        this.getAllOffers();
    }

    search(data) {
        this.http.post('http://localhost:8080/search', data
        ).subscribe(
            res => {
              console.log(data);
                console.log('Passing the json is done');
                this.result = res;
                console.log(this.result);
            },
            err => {
              console.log(data);
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
        this.dialog.open(OfferDialogComponent, {
            width: '300px'
        });
    }

    openSingInDialog() {
      this.dialog.open(SingInComponent, {
        width: '450px'
      })
    }
}
