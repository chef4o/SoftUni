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

export async function asyncDataFetch(url) {
    const result = await fetch(url);
    return result.json();
}

export function btnSwitcher(activeBtn, inactiveBtn) {
    activeBtn.disabled = true;
    inactiveBtn.disabled = false;
}

