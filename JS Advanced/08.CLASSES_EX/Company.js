class Company {
    constructor() {
        this.departments = {};
    }

    addEmployee(name, salary, position, department) {
        this.inputValidation(name, salary, position, department);
        const employee = {
            name: name,
            salary: Number(salary), 
            position: position
        }
        if (!this.departments[department]) {
            this.departments[department] = [];
        }
        this.departments[department].push(employee);

        return `New employee is hired. Name: ${employee.name}. Position: ${employee.position}`;
    }

    bestDepartment() {

        let [bestDpt, bestSalary] = [[], Number.MIN_VALUE];
        
        for (const department of Object.entries(this.departments)) {
            let deptAvgSalary = department[1].reduce((result, current) =>
                result + current.salary / department[1].length, 0);

            if (bestSalary < deptAvgSalary) {
                bestDpt = department;
                bestSalary = Number(deptAvgSalary).toFixed(2);
            }
        }

        let output = `Best Department is: ${bestDpt[0]}\nAverage salary: ${bestSalary}\n`;
        bestDpt[1].sort((a, b) => b.salary - a.salary || a.name.localeCompare(b.name))
                .forEach(e => output += `${e.name} ${e.salary} ${e.position}\n`);
        return output.trim();
    }

    inputValidation(param1, param2, param3, param4) {
        const params = [param1, param2, param3, param4];
        params.forEach(p => {
            if (!p || (typeof p == 'number' && p < 0)) {
                throw new Error('Invalid input!');
            }
        });
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());

