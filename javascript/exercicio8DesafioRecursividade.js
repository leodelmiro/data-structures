const input = {
    "sales": [
        "8349,14/09/2024,899.9,ESPORTE",
        "4837,17/09/2024,530.0,VESTUARIO",
        "15281,21/09/2024,1253.99,ESPORTE",
        "15344,27/09/2024,1000.9,VESTUARIO",
        "18317,04/10/2024,250.4,VESTUARIO",
        "18972,11/10/2024,385.5,JARDINAGEM"
    ],
    "department": "VESTUARIO"
}


function totalSales(sales, department) {
    return sum(sales, department)
}

function sum(sales, department, index = 0, totalUnit = 0, totalValue = 0) {
    if (index >= sales.length) {
        const roundedTotal = Math.round(totalValue * 100) / 100
        return [totalUnit, roundedTotal]
    }

    const [id, date, value, departmentSale] = sales[index].split(",")

    if (departmentSale === department) return sum(sales, department, index + 1, totalUnit + 1, Number(value) + Number(totalValue))
    return sum(sales, department, index + 1, totalUnit, totalValue)
}

console.log(totalSales(input.sales, input.department))