import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {HttpClient} from "@angular/common/http";
import {AlertsService} from "angular-alert-module";

@Component({
  selector: 'app-offer-dialog',
  templateUrl: './offer-dialog.component.html',
  styleUrls: ['./offer-dialog.component.css']
})
export class OfferDialogComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<OfferDialogComponent>,
              private http : HttpClient,
              private alerts : AlertsService,
              @Inject(MAT_DIALOG_DATA) public walkingTourId: any) { }

  ngOnInit() {
  }

  closeDialog(){
    this.dialogRef.close();
  }

  saveDialogBookingData(data){
    let walkingTourData = '{ \'id\':' + this.walkingTourId + ', \'visitDate\':\''+ data['visitDate'] +'\'}';
    console.log(walkingTourData);
    this.http.post("http://localhost:8080/saveBooking", walkingTourData).subscribe( success => {
      this.alerts.setMessage('Saved', 'success')
    }, error1 => {
      this.alerts.setMessage('Can\'t save the booking', 'error');
    });
  }

}
