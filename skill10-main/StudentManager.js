import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

const initialStudents = [
{ id: 30123, name: "Chaitu", course: "React" },
{ id: 30124, name: "Cherry", course: "Java" },
{ id: 30125, name: "Ganga", course: "Python" },
{ id: 30126, name: "Karthik", course: "Data Science" },
{ id: 30127, name: "Yaswanth", course: "NodeJS" }
];

const [students, setStudents] = useState(initialStudents);

const [newStudent, setNewStudent] = useState({
id: "",
name: "",
course: ""
});

const handleChange = (e) => {
setNewStudent({
...newStudent,
[e.target.name]: e.target.value
});
};

const addStudent = () => {

if(!newStudent.id || !newStudent.name || !newStudent.course) return;

setStudents([...students, newStudent]);

setNewStudent({
id: "",
name: "",
course: ""
});
};

const deleteStudent = (id) => {
setStudents(students.filter(student => student.id !== id));
};

return (
<div className="container">

<h2>Student Manager</h2>

<div className="form">

<input
type="text"
name="id"
placeholder="ID"
value={newStudent.id}
onChange={handleChange}
/>

<input
type="text"
name="name"
placeholder="Name"
value={newStudent.name}
onChange={handleChange}
/>

<input
type="text"
name="course"
placeholder="Course"
value={newStudent.course}
onChange={handleChange}
/>

<button onClick={addStudent}>Add Student</button>

</div>

{students.length === 0 ? (

<p>No students available</p>

) : (

<table>

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Action</th>
</tr>
</thead>

<tbody>

{students.map((student) => (
<tr key={student.id}>
<td>{student.id}</td>
<td>{student.name}</td>
<td>{student.course}</td>
<td>
<button onClick={() => deleteStudent(student.id)}>
Delete
</button>
</td>
</tr>
))}

</tbody>

</table>

)}

</div>
);
}

export default StudentManager;