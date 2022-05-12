import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/_models/student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students: Student[] = [
    new Student(1, "Sarah", 24, 1),
    new Student(2, "Mohamed", 24, 2),
    new Student(3, "AbdElDayem", 24, 3)];

  newStudent: Student = new Student(0, "", 0, 0);
  viewStudent: Student = new Student(0, "hiddenDiv", 0, 0);
  student: Student = new Student(0, "hiddenDiv", 0, 0);

  addNewStudent() {
    this.students.push(new Student(this.newStudent.id, this.newStudent.name, this.newStudent.age, this.newStudent.deptno));
    this.newStudent.id = 0;
    this.newStudent.name = "";
    this.newStudent.age = 0;
    this.newStudent.deptno = 0;
  }

  showStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i].id == studentId) {
        this.viewStudent = this.students[i];
        break;
      }
    }
  }

  
  editDivRender(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i].id == studentId) {
        this.student = new Student(this.students[i].id, this.students[i].name, this.students[i].age, this.students[i].deptno);
        break;
      }
    }
  }

  editStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i].id == studentId) {
        this.students[i] = new Student(this.student.id, this.student.name, this.student.age, this.student.deptno);
        break;
      }
    }
  }


  deleteStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i].id == studentId) {
        this.students.splice(i, 1);
        break;
      }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }
}
