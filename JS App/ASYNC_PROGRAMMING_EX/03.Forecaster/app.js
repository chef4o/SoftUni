import { domElement, asyncDataFetch } from '../helpers.js';

function attachEvents() {
    document.getElementById('submit').addEventListener('click', getWeather);
}
attachEvents();

async function getWeather() {
    const submitBtn = document.getElementById('submit');
    let townName = document.querySelector('#location').value.toLowerCase().trim();
    const forecast = document.querySelector('#forecast');
    const todayField = forecast.querySelector('#current');
    const nextDaysField = forecast.querySelector('#upcoming');
    todayField.replaceChildren();
    nextDaysField.replaceChildren();

    submitBtn.disabled = true;
    todayField.appendChild(domElement('div', {className: "label"}, "Loading..."));
    const townNameValidator = /^[a-z]+([.\s-]{0,2}[a-z]+){0,}$/;

    try{
        if (!townName.match(townNameValidator)) {
            throw new Error('Please enter a valid town name');
        } else {
            const towns = await getTownData('');
            const town = towns.find(town => town.name.toLowerCase() == townName);
            if (town == undefined) {
                document.querySelector('#location').value = '';
                throw new Error(`No details available for town ${townName}`);
            } else {
                document.querySelector('#location').value = '';
                const [today, nextDays] = await Promise.all([
                    getWeatherInfo('today', town.code),
                    getWeatherInfo('upcoming', town.code)
                ]);
                
                todayField.replaceChildren();
                const todayElement = generateTodayView(today);
                todayField.appendChild(domElement('div', {className: "label"}, "Current conditions"));
                todayField.appendChild(todayElement);
                const nextDaysElement = generateNextDaysView(nextDays);
                nextDaysField.appendChild(domElement('div', {className: "label"}, "Three-day forecast"));
                nextDaysField.appendChild(nextDaysElement);
                forecast.style.display = 'block';
            }
        } 
    } catch (error) {
        document.querySelector('#location').value = '';
        todayField.replaceChildren();
        todayField.appendChild(domElement('div', {className: "label"}, "Error"));
        forecast.style.display = 'block';
        console.log(error.message);
    }
    submitBtn.disabled = false;
}

function iconCode(condition) {
    switch (condition) {
        case 'Sunny':        return '☀';
        case 'Partly sunny': return '⛅';
        case 'Overcast':     return '☁';
        case 'Rain':         return '☂';
        default: return undefined;
    }
}

function generateTodayView(query) {
    const element = domElement('div', {className: "forecasts"});
        const symbol = domElement('span', {className: "condition symbol"});
            symbol.textContent = iconCode(query.forecast.condition);
        const conditionOverview = domElement('span', {className: "condition"});
            const townName = domElement('span', {className: "forecast-data"});
            townName.textContent =  query.name;
            const minMaxTemps = domElement('span', {className: "forecast-data"});
            minMaxTemps.textContent =  `${query.forecast.low}°/${query.forecast.high}°`;
            const condition = domElement('span', {className: "forecast-data"});
            condition.textContent = query.forecast.condition;
            conditionOverview.appendChild(townName);
            conditionOverview.appendChild(minMaxTemps);
            conditionOverview.appendChild(condition);
        element.appendChild(symbol);
        element.appendChild(conditionOverview);
    return element;
}

function generateNextDaysView(query) {
    const element = domElement('div', {className: "forecast-info"});

    Object.values(query.forecast).forEach(day => {
        const upcoming = domElement('span', {className: "upcoming"});
            const symbol = domElement('span', {className: "symbol"});
            symbol.textContent = iconCode(day.condition);
            const minMaxTemps = domElement('span', {className: "forecast-data"});
            minMaxTemps.textContent =  `${day.low}°/${day.high}°`;
            const condition = domElement('span', {className: "forecast-data"});
            condition.textContent = day.condition;
            upcoming.appendChild(symbol);
            upcoming.appendChild(minMaxTemps);
            upcoming.appendChild(condition);
        element.appendChild(upcoming);
    })
    return element;
}

async function getTownData(townName) {
    return await asyncDataFetch(`http://localhost:3030/jsonstore/forecaster/locations/${townName}`);
}

async function getWeatherInfo(period, locatinoCode) {
    return await asyncDataFetch(`http://localhost:3030/jsonstore/forecaster/${period}/${locatinoCode}`);
}

