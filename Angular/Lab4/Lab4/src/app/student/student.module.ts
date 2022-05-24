import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentAddComponent } from './student-add/student-add.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { FormsModule } from '@angular/forms';
import {DialogModule} from 'primeng/dialog';



@NgModule({
  declarations: [
    StudentAddComponent,
    StudentListComponent,
    StudentDetailsComponent
  ],
  imports: [
    CommonModule, 
    FormsModule,
    DialogModule,
  ],
  exports: [
    StudentAddComponent,
    StudentListComponent,
    StudentDetailsComponent,
    
  ]
})
export class StudentModule { }
