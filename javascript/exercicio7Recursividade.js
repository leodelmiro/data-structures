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