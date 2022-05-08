import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { DepartmentComponent } from './department/department.component';
import { StudentComponent } from './student/student.component';

@NgModule({
  declarations: [AppComponent, DepartmentComponent, StudentComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}