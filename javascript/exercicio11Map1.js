const votes = [
    "Alex Blue,15",
    "Maria Green,22",
    "Bob Brown,21",
    "Alex Blue,30",
    "Bob Brown,15",
    "Maria Green,27",
    "Maria Green,22",
    "Bob Brown,25",
    "Alex Blue,31"
]


function counting(votes) {
    const voteMap = new Map();
    const result = []

    for(i in votes) {
        const [name, count] = votes[i].split(",")

        voteMap.set(name, (voteMap.get(name) || 0) + Number(count));
    }

    for (const [key, value] of voteMap.entries()) {
        result.push(`${key},${value}`)
    }

    return result
}

console.log(counting(votes))