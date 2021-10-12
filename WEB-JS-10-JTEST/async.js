const sum = require("./sum");

function sumPromise(a, b) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(sum(a, b))
        }, 1000)
    })
}
async function asyncSum(a, b) {
    return await sumPromise(a, b)
}

module.exports = asyncSum;