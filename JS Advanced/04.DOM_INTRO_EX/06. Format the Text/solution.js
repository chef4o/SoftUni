function solve() {
  const sentences = document.getElementById('input').value
                            .split('.')
                            .filter((el) => el != '');
  let outputString = '';

  counter = 0;
  let paragraph = ''
  for (let index = 0; index < sentences.length; index++) {
    const sentence = sentences[index];
    paragraph += `${sentence}.`;
    counter++;
    if (counter % 3 == 0 || index == sentences.length -1) {
      outputString += `<p>${paragraph}</p>`;
      paragraph = '';
    }
  }

  document.getElementById('output').innerHTML = outputString;

}