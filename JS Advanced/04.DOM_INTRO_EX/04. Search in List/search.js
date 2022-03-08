function search() {
   let towns = Array.from(document.querySelectorAll('#towns li'));
   const searchField = document.getElementById('searchText').value;
   let matches = 0;

   if (searchField != '') {
      towns.forEach(town => {
         if (town.textContent.includes(searchField)) {
            town.style.fontWeight = 'bold';
            town.style.textDecoration  = 'underline';
            matches++;
         } else {
            town.style.fontWeight = 'normal';
            town.style.textDecoration  = '';
         }
      });
      document.getElementById('result').textContent = `${matches} matches found`;
   }
}