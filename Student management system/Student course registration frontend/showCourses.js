function showCourses() {
    fetch("http://localhost:8080/courses")
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            return response.json();
        })
        .then(courses => {
            const table = document.getElementById("courseTable");
            table.innerHTML = ""; // Clear previous rows if any

            courses.forEach(course => {
                const row = `
                    <tr>
                        <td>${course.courseId}</td>
                        <td>${course.courseName}</td>
                        <td>${course.trainer}</td>
                        <td>${course.durationInWeeks}</td>
                    </tr>
                `;
                table.innerHTML += row;
            });
        })
        .catch(error => {
            console.error("Error fetching courses:", error);
            const table = document.getElementById("courseTable");
            table.innerHTML = `<tr><td colspan="4" style="color:red;">Failed to load courses. Please try again later.</td></tr>`;
        });
}
