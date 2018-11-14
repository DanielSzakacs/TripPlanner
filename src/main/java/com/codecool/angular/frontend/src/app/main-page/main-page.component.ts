import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./static/css/bootstrap/bootstrap.min.css', './static/css/others/pe-icon-7-stroke.css', './static/css/others/magnific-popup.css', './static/css/others/animate.css',
    './static/css/responsive/responsive.css', './main-page.component.css']
})
export class MainPageComponent implements OnInit {
  result;
  name = 'Name';

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.getAllOffers();
  }

  search(data) {
    this.http.post('http://localhost:8088/data', {data}
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

  getAllOffers(){
    this.http.get('http://localhost:8088/data').subscribe((data) => this.result = data, error1 => {console.log(error1)});
    console.log(this.result);
  }




}
