class Product:
    def __init__(self, name, price, quantity):
        self.name = name
        self.price = price
        self.quantity = quantity

    def total(self):
        return self.price * self.quantity

    def update_price(self, percentage):
        self.price = self.price * (1 + percentage / 100)

    def __str__(self):
        return f"name: {self.name}, price: {self.price}, quantity: {self.quantity}"


p1 = Product("Laptop", 1000.0, 2)
print(p1)
