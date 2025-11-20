function sum(num) {
    if (num <= 1) {
        return num
    }

    return num + sum(num - 1)
}

console.log(sum(0))
console.log(sum(1))
console.log(sum(2))
console.log(sum(3))
console.log(sum(4))

function factorial(num) {
    if (num === 0) {
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
    if (num === 0) {
        return acumulador
    }

    return factorialComRecursividadeDeCauda(num - 1, num * acumulador)
}

console.log(factorialComRecursividadeDeCauda(0))
console.log(factorialComRecursividadeDeCauda(1))
console.log(factorialComRecursividadeDeCauda(2))
console.log(factorialComRecursividadeDeCauda(3))
console.log(factorialComRecursividadeDeCauda(4))

function fibonacci(num) {
    if (num <= 0) {
        return 0
    }
    if (num == 1) {
        return 1
    }

    return fibonacci(num - 1) + fibonacci(num - 2)
}

console.log(fibonacci(0))
console.log(fibonacci(1))
console.log(fibonacci(2))
console.log(fibonacci(3))
console.log(fibonacci(4))
console.log(fibonacci(5))
console.log(fibonacci(6))

function fibonacciComRecursividadeDeCauda(num, a = 0, b = 1) {
    if (num === 0) {
        return a
    }
    if (num === 1) {
        return b
    }

    return fibonacciComRecursividadeDeCauda(num - 1, b, a + b)
}

console.log(fibonacciComRecursividadeDeCauda(0))
console.log(fibonacciComRecursividadeDeCauda(1))
console.log(fibonacciComRecursividadeDeCauda(2))
console.log(fibonacciComRecursividadeDeCauda(3))
console.log(fibonacciComRecursividadeDeCauda(4))
console.log(fibonacciComRecursividadeDeCauda(5))
console.log(fibonacciComRecursividadeDeCauda(6))