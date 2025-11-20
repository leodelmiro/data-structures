const input = [
    {
        "name": "Barry Allen",
        "amount": 18196.0
    },
    {
        "name": "Logan",
        "amount": 4255.0
    },
    {
        "name": "Maria",
        "amount": 10298.0
    },
    {
        "name": "Ana",
        "amount": 26485.0
    },
    {
        "name": "Aurora",
        "amount": 19982.0
    },
    {
        "name": "Noah",
        "amount": 15820.0
    },
    {
        "name": "Leo",
        "amount": 21412.0
    },
    {
        "name": "Alex",
        "amount": 12000.0
    }
]

function findMaxSellerAmount(sellers) {
    let topSeller = sellers[0]

    for (let i = 1; i < sellers.length; i++ ) {
        if(sellers[i].amount > topSeller.amount) topSeller = sellers[i]
    }

    return topSeller
}

console.log(findMaxSellerAmount(input))