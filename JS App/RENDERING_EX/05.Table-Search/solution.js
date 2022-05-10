import { html, render } from '../node_modules/lit-html/lit-html.js';

const root = document.querySelector('tbody');
let students;

async function solve() {  
   await getStudents();
   update(students);
   document.querySelector('#searchBtn').addEventListener('click', onClick);
   function onClick() {
      update(students);
   }
}
solve();

const studentTemplate = (students) => html`
         ${students.map(student => html`
         <tr>
            <th class="${student.selected}">${`${student.firstName} ${student.lastName}`}</th>
            <th class="${student.selected}">${student.email}</th>
            <th class="${student.selected}">${student.course}</th>
         </tr>
         `)}`;

async function getStudents() {
   const res = await fetch('http://localhost:3030/jsonstore/advanced/table');
   students =  Object.values(await res.json());
}

function update(data) {
   const searchField = document.getElementById('searchField').value.toLocaleLowerCase().trim();
   const enrichedData = data.map(student => {
      student.selected = Object.values(student)
         .find(p => searchField && p.toLocaleLowerCase().includes(searchField)) ? 'select' : '';
      return student;
   });
   const content = studentTemplate(enrichedData);
   render(content, root);
}