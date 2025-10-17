import React, { useState, useEffect } from 'react';

const initialStudents = [
  { id: 1, name: 'Alice Johnson', isPresent: false },
  { id: 2, name: 'Bob Smith', isPresent: false },
  { id: 3, name: 'Charlie Brown', isPresent: false },
  { id: 4, name: 'Diana Prince', isPresent: false },
  { id: 5, name: 'Ethan Hunt', isPresent: false },
];


const AttendanceTracker = () => {

  const [students, setStudents] = useState(initialStudents);


  const [presentCount, setPresentCount] = useState(0);


  useEffect(() => {

    const count = students.filter(student => student.isPresent).length;
    setPresentCount(count);
  }, [students]); 


  const handleAttendanceToggle = (studentId) => {
    setStudents(prevStudents =>
      prevStudents.map(student =>
        student.id === studentId
          ? { ...student, isPresent: !student.isPresent } 
          : student
      )
    );
  };

  return (
    <div className="attendance-tracker" style={{ 
      maxWidth: '450px', 
      margin: '40px auto', 
      padding: '20px', 
      border: '1px solid #ddd', 
      borderRadius: '8px',
      fontFamily: 'Arial, sans-serif'
    }}>
      <h2 style={{ borderBottom: '2px solid #007bff', paddingBottom: '10px', color: '#333' }}>
        Attendance Sheet 🧑‍🏫
      </h2>

      {/* Dynamic Count Display */}
      <div style={{ 
        backgroundColor: '#e9ecef', 
        padding: '15px', 
        borderRadius: '5px', 
        textAlign: 'center',
        marginBottom: '20px'
      }}>
        Total Students: {students.length} | **Present Now:** <strong style={{ color: '#28a745', fontSize: '1.2em' }}>{presentCount}</strong>
      </div>

      {/* List of Students */}
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {students.map(student => (
          <li
            key={student.id}
            style={{
              display: 'flex',
              justifyContent: 'space-between',
              alignItems: 'center',
              padding: '12px 10px',
              marginBottom: '8px',
              borderRadius: '4px',
              backgroundColor: student.isPresent ? '#d4edda' : '#f8f9fa', 
              borderLeft: student.isPresent ? '5px solid #28a745' : '5px solid #ccc',
              transition: 'background-color 0.3s'
            }}
          >
            <span style={{ fontWeight: 'bold', color: '#495057' }}>{student.name}</span>
            <label style={{ display: 'flex', alignItems: 'center', cursor: 'pointer' }}>
              <input
                type="checkbox"
                checked={student.isPresent}
                onChange={() => handleAttendanceToggle(student.id)}
                style={{ 
                  marginRight: '5px',
                  transform: 'scale(1.3)', 
                  cursor: 'pointer'
                }}
              />
              Present
            </label>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AttendanceTracker;