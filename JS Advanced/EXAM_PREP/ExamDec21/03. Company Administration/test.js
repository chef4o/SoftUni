const { companyAdministration } = require('./companyAdministration');
const { expect } = require('chai');

describe('Test all methods', () => {

    describe('Test hiringEmployee method', () => {

        it('position not a Programmer throws error', () => {
            expect(() => companyAdministration.hiringEmployee('Test', 'HR', 5)).to.throw(`We are not looking for workers for this position.`);
        })
        it('does not have experience throws error', () => {
            expect(companyAdministration.hiringEmployee('Test', 'Programmer', 1)).to.equal(`Test is not approved for this position.`);
        })
        it('proper data approves employee', () => {
            expect(companyAdministration.hiringEmployee('Test', 'Programmer', 10)).to.equal(`Test was successfully hired for the position Programmer.`);
            expect(companyAdministration.hiringEmployee('Test', 'Programmer', 3)).to.equal(`Test was successfully hired for the position Programmer.`);
        })
    })


    describe('Test calculateSalary  method', () => {

        it('wrond input data', () => {
            expect(() => companyAdministration.calculateSalary(-100)).to.throw(`Invalid hours`);
            expect(() => companyAdministration.calculateSalary("20")).to.throw(`Invalid hours`);
            expect(() => companyAdministration.calculateSalary([])).to.throw(`Invalid hours`);
            expect(() => companyAdministration.calculateSalary({})).to.throw(`Invalid hours`);
        })
        it('correct input data ', () => {
            expect(companyAdministration.calculateSalary(10)).to.equal(150);
            expect(companyAdministration.calculateSalary(200)).to.equal(4000);
        })

    })

    describe('Test firedEmployee   method', () => {

        let employees = ["Petar", "Ivan", "George"];

        it('wrond input data', () => {
            expect(() => companyAdministration.firedEmployee(employees, -1)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(employees, 6)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(employees, 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(employees, null)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(null, null)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee("test", 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(1, 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(1.0, 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee([], 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee({}, 2.5)).to.throw(`Invalid input`);
            expect(() => companyAdministration.firedEmployee(null, 2.5)).to.throw(`Invalid input`);
        })
        it('Correct input', () => {
            expect(companyAdministration.firedEmployee(employees, 1)).to.equal("Petar, George");
            expect(companyAdministration.firedEmployee(employees, 1)).to.equal("Petar, George");
        })


    })

})