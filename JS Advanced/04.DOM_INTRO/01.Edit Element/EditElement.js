function editElement(element, match, replacer) {
    const output = element.textContent.split(match).join(replacer);
    element.textContent = output;
}