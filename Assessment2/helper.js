const hat = '^';
const hole = 'O';
const field = '░';
const path = '*';

const fillUpObstacle = () => {
    let char = ""

    // probability for generating fieldCharacter. Hardcode value and can be changed
    if (Math.random() > 0.9999992) {
        char = field
    } else {
        char = hole
    }

    return char
}

// generate the initial map
const generateMap = () => {
    //   create a 5*5 map
    const map = [
        [], [], [], [], []
    ]

    for (const arr of map) {
        for (let i = 0; i < map.length; i++) {
            arr[i] = fillUpObstacle()
        }
    }

    return map
}

const printMap = (map) => {
    for (const line of map) {
        console.log(line.join(""))
    }
}

module.exports = {
    fillUpObstacle,
    generateMap,
    printMap,
    hat,
    hole,
    field,
    path
}