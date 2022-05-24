import { Injectable } from '@angular/core';
import { Student } from './_models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private students: Student[] = [
    new Student(1, "sarah", 30, 2300),
    new Student(2, "mohamed", 15, 400),
    new Student(3, "abdel daym", 70, 500),
  ]

  getAllStudents() {
    return this.students;
  }

  getStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i]._id === studentId) {
        return this.students[i];
      }
    }
    return null;
  }

  addStudent(newStudent: Student) {
    this.students.push(new Student(newStudent._id, newStudent.name, newStudent.age, newStudent.deptno))
  }
  
  constructor() { }
}
