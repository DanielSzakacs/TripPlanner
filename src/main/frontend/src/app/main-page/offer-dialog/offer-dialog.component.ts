import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-offer-dialog',
  templateUrl: './offer-dialog.component.html',
  styleUrls: ['./offer-dialog.component.css']
})
export class OfferDialogComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<OfferDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  closeDialog(){
    this.dialogRef.close();
  }

  saveDialogBookingData(data){
    this.closeDialog();
    console.log(data);
  }

}
