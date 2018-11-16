import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from "@angular/material";
import { OfferDialogComponent } from './main-page/offer-dialog/offer-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    OfferDialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule
  ],
  entryComponents:[OfferDialogComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
