import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {
  statusCode: Object;
  constructor(private http: HttpClient,
              private dialogRef: MatDialogRef<SingInComponent>) { }

  ngOnInit() {
  }

  sendUserSingInData(data){
    console.log(data);
    this.http.post('http://localhost:8080/login', data).subscribe(result => {
      this.closeDialog();
    },
      error => {
        if(error.status == 401){
          alert('Something wrong');
        }
      });
  }

  sendUserSingUpData(data){
    console.log(data);
    this.http.post('http://localhost:8080/registration', data).subscribe(result => {
        this.closeDialog();
        console.log(result);
      },
      error => {
        if(error.status == 401)
          alert('User is not exist!');
      });
  }

  closeDialog(){
    this.dialogRef.close();
  }


}
