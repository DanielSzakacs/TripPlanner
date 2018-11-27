import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {

  constructor(private http: HttpClient,
              private dialogRef: MatDialogRef<SingInComponent>) { }

  ngOnInit() {
  }

  sendUserSingInData(data){
    console.log(data);
    this.http.post('http://localhost:8088/sign_in', data).subscribe(result => {
      this.closeDialog()
    },
      error => {
      if(error.status == 404)
        alert('Error. Please try is later');
      });
  }

  sendUserSingUpData(data){
    console.log(data);
    this.http.post('http://localhost:8088/sing_up', data).subscribe(result => {
        this.closeDialog();
        console.log(result);
      },
      error => {
        if(error.status == 404)
          alert('Error. Please try later');
      });
  }

  closeDialog(){
    this.dialogRef.close();
  }


}
