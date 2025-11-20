function sum(num) {
    if(num <= 1) {
        return num
    }

    return num + sum(num-1)
}

console.log(sum(0))
console.log(sum(1))
console.log(sum(2))
console.log(sum(3))
console.log(sum(4))

function factorial(num) {
    if(num === 0) {
        return 1
    }

    return num * factorial(num - 1)
}

console.log(factorial(0))
console.log(factorial(1))
console.log(factorial(2))
console.log(factorial(3))
console.log(factorial(4))

function factorialComRecursividadeDeCauda(num, acumulador = 1) {
    if(num === 0) {
        return acumulador
    }

    return factorialComRecursividadeDeCauda(num - 1, num * acumulador)
}

console.log(factorialComRecursividadeDeCauda(0))
console.log(factorialComRecursividadeDeCauda(1))
console.log(factorialComRecursividadeDeCauda(2))
console.log(factorialComRecursividadeDeCauda(3))
console.log(factorialComRecursividadeDeCauda(4))