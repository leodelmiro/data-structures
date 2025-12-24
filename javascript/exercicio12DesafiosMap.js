const input = [
    "57,Vendas,8032,Meire Silva,8000.0,57",
    "18,Marketing,6421,Davi Souto,7500.0,18",
    "18,Marketing,2732,Bob Costa,6500.0,18"
]

class Department {
    constructor(id, name) {
        this.id = id
        this.name = name
        this.employees = []
    }

    addEmployee(employee) {
        this.employees.push(employee)
    }
}

class Employee {
    constructor(id, name, salary) {
        this.id = id
        this.name = name
        this.salary = salary
    }
}

function convertRecords(records) {
    const departments = new Map()

    for (index in records) {
        const [departmentId, departmentName, employeeId, employeeName, employeeSalary] = records[index].split(",")

        let department = departments.get(departmentName);
        if (!department) {
            department = new Department(Number(departmentId), departmentName);
            departments.set(departmentName, department);
        }
        department.addEmployee(new Employee(Number(employeeId), employeeName, Number(employeeSalary)))
    }
    const result = Array.from(departments.values()).sort((a, b) => a.name.localeCompare(b.name));

    return result
}

function printDepartments(departments) {
    for (index in departments) {
        console.log(departments[index].name + ":")
        departments[index].employees.forEach(employee => {
            console.log(`\t${employee.id}: ${employee.name}, $ ${employee.salary.toFixed(2)}`)
        });
    }
}

printDepartments(convertRecords(input))