function solve() {
  const input = document.getElementById('text').value
                        .split(' ');
  const convention = document.getElementById('naming-convention').value;

  let camelCase = (text) => {
    let convertedText = text[0].toLowerCase();
    for (let index = 1; index < text.length; index++) {
      const word = text[index].toLowerCase();
        convertedText += word.charAt(0).toUpperCase() + word.slice(1);
    }
    return convertedText;
  }

  let pascalCase = (text) => {
    let convertedText = '';
    for (let index = 0; index < text.length; index++) {
      const word = text[index].toLowerCase();
      convertedText += word.charAt(0).toUpperCase() + word.slice(1);
    }
    return convertedText;
  }

  let output = '';
  switch (convention) {
    case 'Camel Case': {
      output = camelCase(input);
    }
      break;
    case 'Pascal Case': {
      output = pascalCase(input);
      }
      break;
    default: output = 'Error!';
      break;
  }

  document.getElementById('result').textContent = output;
}