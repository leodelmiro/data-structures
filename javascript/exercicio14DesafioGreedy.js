input = [
    {
        "n": 2,
        "m": 3,
        "diameters": [5, 4],
        "heights": [7, 8, 4]
    },
    {
        "n": 2,
        "m": 1,
        "diameters": [5, 5],
        "heights": [10]
    },
    {
        "n": 2,
        "m": 4,
        "diameters": [7, 2],
        "heights": [4, 3, 1, 2]
    },
    {
        "n": 2,
        "m": 4,
        "diameters": [7, 2],
        "heights": [2, 1, 8, 5]
    },
    {
        "n": 2,
        "m": 10,
        "diameters": [1234567, 2345],
        "heights": [12345610, 1, 123, 23564,
            123456, 123, 2, 3, 2, 1]
    }
]

function agualoo(n, m, diameters, heights) {
    diameters.sort()
    heights.sort()

    let i = 0
    let j = 0
    let minimumCoins = 0

    while (i < diameters.length && j < heights.length) {
        if (heights[j] >= diameters[i]) {
            minimumCoins += heights[j]
            i++
            j++
            continue
        }

        j++
    }

    if (i === diameters.length) {
        return minimumCoins
    }

    return "Agualoo esta condenada!"
}

for (i in input) {
    const { n, m, diameters, heights } = input[i]
    console.log(agualoo(n, m, diameters, heights))
}

