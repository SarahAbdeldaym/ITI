import { Component } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {PasswordModule} from 'primeng/password';
import {RatingModule} from 'primeng/rating';
import {CalendarModule} from 'primeng/calendar';
import {ChipsModule} from 'primeng/chips';
import {GMapModule} from 'primeng/gmap';
import {FileUploadModule} from 'primeng/fileupload';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Lab2';
}
