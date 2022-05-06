const main = document.querySelector('main');

export function showSection(section) {
    main.replaceChildren(section);
}

export function domElement(type, attributes, ...content) {
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