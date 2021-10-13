const { fillUpObstacle, generateMap, printMap, hat, hole, field, path } = require('./helper')
// copy from documentation
// https://nodejs.dev/learn/accept-input-from-the-command-line-in-nodejs
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
})
const acceptableInput = ["T", "R", "L", "D"]
const lastPathCoor = [0, 0]

const setup = () => {
    let map = generateMap()
    while (map[0][1] === hole && map[1][0] === hole) {
        map = generateMap()
    }
    // generate the map again, if two holes blocked the initial starting point
    // if (map[0][1] === hole && map[1][0] === hole) {
    //     return setup()
    // }
    // set initial pathCharacter
    map[0][0] = path
    // set hat in a random place
    map[Math.floor((Math.random() * 10) / (10 / map.length))][Math.floor((Math.random() * 10) / (10 / map.length))] = hat

    return map
}

const initialMap = setup()

console.log(`
@@@@@@@@@@@@@
@Game Start!@
@@@@@@@@@@@@@
`)

const createPrompt = (handler) => {
    printMap(initialMap)
    readline.question(`Which way?`, handler)
}

// callback for the readline function
const handleInput = (input) => {
    if (!acceptableInput.includes(input)) {
        console.log(`${input} is not an acceptable input.`)
        return createPrompt(handleInput)
    }

    //Copy the last path coordinate here. So that a failed move will not change the value of lastPathCoor
    const copied = [...lastPathCoor]

    switch (input) {
        case 'T': {
            copied[0] = copied[0] - 1// Y-1
            break
        }
        case 'D': {
            copied[0] = copied[0] + 1//Y+1
            break
        }
        case 'L': {
            copied[1] = copied[1] - 1//X-1
            break
        }
        case 'R': {
            copied[1] = copied[1] + 1//X+1
            break
        }
    }

    const [y, x] = copied
    // y=copied[0]
    // x=copied[1]

    // Check if it is an out of bound error or not
    if (x < 0 || y < 0 || y > initialMap.length - 1 || x > initialMap[0].length - 1) {
        console.log("This move is out of bound!")
        return createPrompt(handleInput)
    }

    //Update last coordinate as it is a valid move
    lastPathCoor[0] = copied[0]
    lastPathCoor[1] = copied[1]

    //Check if that coordinate is movable
    switch (initialMap[y][x]) {
        case hat: {
            console.log('You have found the hat!')
            console.log(`
            @@@@@@@@@@
            @You won!@
            @@@@@@@@@@
            `)
            readline.close()
            break
        }
        case hole: {
            console.log('You stepped into a hole!')
            console.log(`
            @@@@@@@@@@@
            @Game over@
            @@@@@@@@@@@
            `)
            readline.close()
            break
        }
        case path: {
            console.log('You cannot move back!')
            return createPrompt(handleInput)
        }
        case field: {
            initialMap[y][x] = path
            return createPrompt(handleInput)
        }
    }
}

createPrompt(handleInput)