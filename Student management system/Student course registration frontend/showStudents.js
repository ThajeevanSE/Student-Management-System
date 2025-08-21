async function showStudents() {
    try {
        const response = await fetch('http://localhost:8080/students'); // backend port
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const students = await response.json();

        const tableBody = document.getElementById('studentsTable');
        tableBody.innerHTML = '';

        if (students.length === 0) {
            tableBody.innerHTML = '<tr><td colspan="4">No students enrolled yet.</td></tr>';
            return;
        }

        students.forEach(student => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.emailId}</td>
                <td>${student.courseName}</td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error fetching students:', error);
        document.getElementById('studentsTable').innerHTML = '<tr><td colspan="4">Failed to load students.</td></tr>';
    }
}
