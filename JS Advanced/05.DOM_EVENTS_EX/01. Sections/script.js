function create(words) {
   const content = document.getElementById('content');
   content.addEventListener('click', reveal);

   for (const word of words) {
      const div = document.createElement('div');
      const p = document.createElement('p');
      p.textContent = word;
      p.style.display = 'none';

      div.appendChild(p);
      content.appendChild(div);
   }

   function reveal (ev) {
      if (ev.target.tagName == 'DIV'
         && ev.target.id != 'content') {
            ev.target.children[0].style.display = 'block';
      }
   }  
}