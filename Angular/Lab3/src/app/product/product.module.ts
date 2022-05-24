import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductComponent } from './product/product.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { StringConvertPipe } from './string-convert.pipe';
import { ArraySplicePipe } from './array-splice.pipe';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {PasswordModule} from 'primeng/password';
import {RatingModule} from 'primeng/rating';
import {CalendarModule} from 'primeng/calendar';
import {ChipsModule} from 'primeng/chips';
import {GMapModule} from 'primeng/gmap';
import {FileUploadModule} from 'primeng/fileupload';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from "primeng/button";
import {InputTextModule} from 'primeng/inputtext';
import {RippleModule} from "primeng/ripple";
import {InputNumberModule} from "primeng/inputnumber";


@NgModule({
  declarations: [
    ProductComponent,
    StringConvertPipe,
    ArraySplicePipe
  ],
  imports: [
    CommonModule, 
    SharedModule,
    FormsModule,
    DialogModule,
    BrowserAnimationsModule,
    CalendarModule,
    RatingModule,
    PasswordModule
  ],
  exports: [
    ProductComponent
  ]
})
export class ProductModule { }


