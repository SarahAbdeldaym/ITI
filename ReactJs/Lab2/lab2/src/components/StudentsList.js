import { NavLink } from "react-router-dom";

let StudentsList = ({ studentsList }) => {
    let renderStudents = () => {
        if (studentsList.length > 0) {
            return studentsList.map((student) => {
                return (
                    <div key={student.id} className="studentItem">
                        <h3>Name: {student.name}</h3>
                        <h3 >Age: {student.age}</h3>
                        <NavLink 
                         style={{ 'color': "white"}}

                        to={`students/${student.id}`}  >View</NavLink>
                    </div>
                )
            })
        } else {
            return (<h1>No Students</h1>)
        }
    }
    return (
        <div className="comp">
            <h2 className="header">Students</h2>
            {renderStudents()}
        </div>
    )
}

export default StudentsList;