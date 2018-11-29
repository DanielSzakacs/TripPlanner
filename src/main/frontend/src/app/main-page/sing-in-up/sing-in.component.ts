import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {MainPageComponent} from "../main-page.component";
import {AlertsService} from "angular-alert-module";

@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {
  constructor(private http: HttpClient,
              private dialogRef: MatDialogRef<SingInComponent>,
              private alerts: AlertsService,
              @Inject(MAT_DIALOG_DATA) public data: MainPageComponent) { }

  ngOnInit() {
  }

  sendUserSingInData(data){
    console.log(data);
    this.http.post('http://localhost:8080/login', data).subscribe(result => {
      this.closeDialog();
      this.alerts.setMessage('Logged in', 'success');
    },
      error => {
        alert('Something wrong');
      });
    this.data.checkIfUserLoggedIn();
  }

  sendUserSingUpData(data) {
    console.log(data);
    this.http.post('http://localhost:8080/registration', data).subscribe(result => {
        this.closeDialog();
        //this.mainPageComponent.ngOnInit(); // TODO
        this.alerts.setMessage('You sing up successful', 'success');
      },
      error => {
        if(error.status == 401){
          alert('Your password is not match');
        }
          alert('Error. Please try later');
      });
  }

  closeDialog(){
    this.dialogRef.close();
  }


}
