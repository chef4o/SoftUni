function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const students = Array.from(document.querySelectorAll('.container tbody tr'));
      const searchElement = document.getElementById('searchField').value;

      students.forEach((student) => {
         let match = false;
         const studentData = Array.from(student.children);

         studentData.forEach((element) => {
            if (element.textContent.includes(searchElement)) {
               match = true;
            }

         });

         if (match && searchElement != '') {
            student.classList.add('select');
         } else {
            student.classList.remove('select');
         }

      });

   }
}