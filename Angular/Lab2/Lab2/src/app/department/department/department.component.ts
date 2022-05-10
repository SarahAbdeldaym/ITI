import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/_models/department';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  departments: Department[] = [
    new Department(1, "OS", "Alex"),
    new Department(2, "WEB", "Alex"),
    new Department(3, "Mobile", "Alex")];

  newDepartment: Department = new Department(0, "", "");
  viewDepartment: Department = new Department(0, "hiddenDiv", "");
  department: Department = new Department(0, "hiddenDiv", "");

  addNewDepartment() {
    this.departments.push(new Department(this.newDepartment.id, this.newDepartment.deptname, this.newDepartment.location));
    this.newDepartment.id = 0;
    this.newDepartment.deptname = "";
    this.newDepartment.location = "";
  }

  showDepartment(departmentId: number) {
    for (let i = 0; i < this.departments.length; i++) {
      if (this.departments[i].id == departmentId) {
        this.viewDepartment = this.departments[i];
        break;
      }
    }
  }

  editDivRender(departmentId: number) {
    for (let i = 0; i < this.departments.length; i++) {
      if (this.departments[i].id == departmentId) {
        this.department = new Department(this.departments[i].id, this.departments[i].deptname, this.departments[i].location);
        break;
      }
    }
  }

  editDepartment(departmentId: number) {
    for (let i = 0; i < this.departments.length; i++) {
      if (this.departments[i].id == departmentId) {
        this.departments[i] = new Department(this.department.id, this.department.deptname, this.department.location);
        break;
      }
    }
  }


  deleteDepartment(departmentId: number) {
    for (let i = 0; i < this.departments.length; i++) {
      if (this.departments[i].id == departmentId) {
        this.departments.splice(i, 1);
        break;
      }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
