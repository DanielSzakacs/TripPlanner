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

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }

  search(data) {
    this.http.post('http://localhost:8088/data', {data}
    ).subscribe(
      res => {
        console.log('Passing the json is done');
        this.getResults();
      },
      err => {
        console.log('Sorry but something went wrong!');
      }
    );
  }
 //This is the part when you get the searched information via json.
  getResults() {
    this.http.get("http://localhost:8088/data").subscribe(
      res => {
        console.log(res);
        this.result = res;
      },
      err =>{
        alert('Your JSON is not working');
      }
    );
  }

}
