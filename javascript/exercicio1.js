class Product {
    constructor(name, price, quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    total() {
        return this.price * this.quantity
    }

    updatePrice(percentage) {
        this.price = this.price * (1 + percentage / 100)
    }
}

const p1 = new Product("Laptop", 1000.0, 5)
const p2 = new Product("Headphones", 200.0, 2)

console.log()

