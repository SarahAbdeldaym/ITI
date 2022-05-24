import { Injectable } from '@angular/core';
import { Student } from './_models/student';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private students: Student[] = [
    new Student(1, 'Sarah', 24, 100),
    new Student(2, 'Mohamed', 24, 200),
    new Student(3, 'AbdElDaym', 24, 300),
  ];

  getAllStudents() {
    return this.students;
  }

  getStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i]._id == studentId) {
        return this.students[i];
      }
    }
    return null;
  }

  addStudent(newStudent: Student) {
    this.students.push(
      new Student(
        newStudent._id,
        newStudent.name,
        newStudent.age,
        newStudent.deptno
      )
    );
  }

  editStudent(student: Student | null, studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i]._id == studentId && student != null) {
        this.students[i]._id = student._id;
        this.students[i].name = student.name;
        this.students[i].age = student.age;
        this.students[i].deptno = student.deptno;
      }
    }
  }

  deleteStudent(studentId: number) {
    for (let i = 0; i < this.students.length; i++) {
      if (this.students[i]._id == studentId) {
        this.students.splice(i, 1);
        break;
      }
    }
  }

  constructor() {}
}
