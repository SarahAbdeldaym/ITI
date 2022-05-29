
// import {useEffect, useState} from "react";
import StudentsList from "../components/StudentsList";
import AddStudent from "../components/AddStudent";
import students from '../components/students';
import { Component } from "react";

export default class Home extends Component {

  constructor() {
    super();
    this.state = {
      AllStudents: students.students
    }
  }

  addStudent = (data) => {

    let newStudent = {
      name: data.name,
      age: data.age,
      email: data.email,
      id: this.state.AllStudents.length +1
    }

    let addNewStudent = this.state.AllStudents;
    addNewStudent.push(newStudent);
    this.setState({ AllStudents: addNewStudent });
  }

  render() {
    return (
      <div>
        <AddStudent onKeyChange={this.addStudent} />
        <StudentsList studentsList={this.state.AllStudents} />
      </div>
    )
  }
}
