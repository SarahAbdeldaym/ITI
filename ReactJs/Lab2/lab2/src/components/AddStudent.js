import { Component } from "react";
import students from './students';

export default class AddStudent extends Component {

    constructor() {
        super();
        this.state = {
            name: "",
            email: "",
            age: ''
        }
    }
    
    addStudent = ()=>{
        console.log(students.students);
        students.students.push({
            "id":111,
            "name":"Sarah",
            "age":20,
            "email":"Sarah@gmail.com"
        });
        this.setState({name:""});

    }

    render() {
        return (
            <div className="comp">
                <h2 className="header">Add Student</h2>
                Name:<input
                    type="text"
                    value={this.state.name}
                    onChange={(e) => {
                        this.setState({ name: e.target.value })
                    }}
                />
                <br />
                Email:<input
                    type="email"
                    value={this.state.email}
                    onChange={(e) => {
                        this.setState({ email: e.target.value })
                    }}
                />
                <br />
                Age:<input
                    type="number"
                    value={this.state.age}
                    onChange={(e) => {
                        this.setState({ age: e.target.value })
                    }}
                />
                <input
                    type="button"
                    value="Add"
                    style={{ 'color': "white", 'backgroundColor': "black", 'width': '200px' , 'margin-left': "400px" }}

                    onClick={(e)=> {
                        this.props.onKeyChange({name:this.state.name,age:this.state.age,email:this.state.email});
                    }}
                />
            </div>
        )
    }
}