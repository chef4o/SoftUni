window.addEventListener('DOMContentLoaded', () => {
    document.getElementById('submit').addEventListener('click', addStudent);
    loadStudents();
});

async function loadStudents() {
    const studentTbl = document.querySelector('#results tbody');
    studentTbl.replaceChildren();
    const result = await fetch(`http://localhost:3030/jsonstore/collections/students`);
    const data = await result.json();
    Object.values(data).forEach(student => studentTbl.appendChild(createStudent(student)));
}

async function addStudent(ev) {
    const inputFields = document.querySelectorAll('.inputs input');
    ev.preventDefault();
    const formData = new FormData(ev.target.parentNode);
    const studentData = [...formData.entries()].reduce((final, entry) => Object.assign(final, { [entry[0]]: entry[1] }), {})
    try {
        validate(studentData);
        const result = await fetch(`http://localhost:3030/jsonstore/collections/students`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/' },
            body: JSON.stringify(studentData)
        });
        if (result.ok != true) {
            const error = await result.json();
            throw new Error(error.message);
        }
        inputFields.forEach(input => input.value = '');
        loadStudents();
    } catch (error) {
        alert(error.message);
    }
}

function validate(studentData) {
    const output = [];
    if (Object.values(studentData).some(entry => entry == '')) {
        output.push(`There is an empty cell while all fields are mandatory`);
    }
    if (studentData.firstName.trim() != '' && !studentData.firstName.trim().toLowerCase().match('[a-z]+')) {
        output.push(`First name ${studentData.firstName.trim()} is invalid`);
    }
    if (studentData.lastName.trim() != '' && !studentData.lastName.trim().toLowerCase().match('[a-z]+')) {
        output.push(`Last name ${studentData.lastName.trim()} is invalid`);
    }
    if (!parseInt(studentData.facultyNumber.trim())) {
        output.push('Faculty number must be an integer value');
    }
    if (!studentData.grade.trim().match('^[2-6].[0-9]{0,2}$')) {
        output.push('Grade must be a valid number');
    }
    if (output.length != 0) {
        throw new Error(`The following errors occurred:\n${output.join('\n')}`);
    }
}

function createStudent(student) {
    const element = domElement('tr', {},
        domElement('td', {}, `${student.firstName}`),
        domElement('td', {}, `${student.lastName}`),
        domElement('td', {}, `${student.facultyNumber}`),
        domElement('td', {}, `${student.grade}`)
    );
    return element;
}

function domElement(type, attributes, ...content) {
    const element = document.createElement(type);
    for (const property in attributes) {
        element[property] = attributes[property];
    }
    for (let item of content) {
        if (typeof item == 'string' || typeof item == 'number') {
            item = document.createTextNode(item);
        }
        element.appendChild(item);
    }
    return element;
}
