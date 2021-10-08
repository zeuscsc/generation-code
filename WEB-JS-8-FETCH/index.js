let form = document.querySelector("#add-form");
let memos = [{ message: "hello world" }]
form.addEventListener("submit", (e) => {
    e.preventDefault();
    let memo_content = document.querySelector("#memo_content");
    memos.push({ message: memo_content.value })
    localStorage.setItem("memos", JSON.stringify(memos))
    updateMemo();
})
function updateMemo() {
    memos = JSON.parse(localStorage.getItem("memos"));
    let postits = document.querySelector("#postits");
    postits.innerHTML = "";
    for (let memo of memos) {
        postits.innerHTML += `
            <div class="col-sm-3 col-12 postit">
                <img class="memo" id="postit" src="postit.png">
                <button class="edit edit_button" data-id=0><i class="fas fa-edit"></i></button>
                <div class="memoCentered">
                    <h5 id="memoEditDisplayText">${memo.message}</h5>
                </div>
                <button class="remove"><i class="fas fa-trash-alt"></i></button>
            </div>
            `;
    }
    let remove_buttons = document.querySelectorAll(".remove")
    for (let i = 0; i < remove_buttons.length; i++) {
        let button = remove_buttons[i];
        button.dataId = i;
        button.addEventListener("click", (e) => {
            let dataId = e.currentTarget.dataId;
            memos.splice(dataId, 1)
            localStorage.setItem("memos", JSON.stringify(memos))
            updateMemo();
        })
    }
    let edit_buttons = document.querySelectorAll(".edit_button")
    for (let i = 0; i < edit_buttons.length; i++) {
        let button = edit_buttons[i];
        button.dataId = i;
        button.addEventListener("click", (e) => {
            let dataId = e.currentTarget.dataId;
            let memo_content = document.querySelector("#memo_content");
            memos[dataId].message = memo_content.value
            localStorage.setItem("memos", JSON.stringify(memos))
            updateMemo();
        })
    }
}
function sqrt(v) {
    if (v < 0)
        throw "Sqrt should have a positive number";
    return v ** (0.5)
}
// console.log(sqrt(-4))
// fetchDemo();
updateMemo();
async function fetchDemo() {
    let res = await fetch("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo");
    let json = await res.json();
    // console.log(json)
    let days = json["Time Series (5min)"]
    let postits = document.querySelector("#postits");
    postits.innerHTML = "";
    for (let memo of Object.entries(days)) {
        let open = memo[1]["1. open"];
        let close = memo[1]["4. close"];
        postits.innerHTML += `
            <div class="col-sm-3 col-12 postit">
                <img class="memo" id="postit" src="postit.png">
                <button class="edit edit_button" data-id=0><i class="fas fa-edit"></i></button>
                <div class="memoCentered">
                    <h5 id="memoEditDisplayText">Open:${open} Close:${close}</h5>
                </div>
                <button class="remove"><i class="fas fa-trash-alt"></i></button>
            </div>
            `;
    }
}

// setTimeout((e) => {
//     console.log("Wait for User data")
//     setTimeout((e) => {
//         console.log("Draw User Data")
//         setTimeout((e) => {
//             console.log("Wait fot Product Data")
//             setTimeout((e) => {
//                 console.log("Draw Product Data")
//             }, 2000)
//         }, 3000)
//     }, 1000)
// }, 2000)
// console.log("Draw Layout")
// console.log("Listen to Interaction")

function waitForUserData() {
    return new Promise((resolve, reject) => {
        setTimeout((e) => {
            if (false) {
                reject("Failed to get response from server")
            }
            console.log("Wait for User data Promise")
            resolve({ userid: 1 })
        }, 2000)
    })
}
function drawUserData() {
    return new Promise((resolve, reject) => {
        setTimeout((e) => {
            console.log("Draw User data Promise")
            resolve()
        }, 1000)
    })
}
function waitForProductData() {
    return new Promise((resolve, reject) => {
        setTimeout((e) => {
            console.log("Wait for Product data Promise")
            resolve({ productid: 1 })
        }, 3000)
    })
}
function drawProductData() {
    return new Promise((resolve, reject) => {
        setTimeout((e) => {
            console.log("Draw Product data Promise")
            resolve()
        }, 2000)
    })
}
async function waitAndDraw() {
    try {
        console.log(await waitForUserData())
    } catch (e) {
        // console.log(e)
    }
    console.log(await drawUserData())
    console.log(await waitForProductData())
    console.log(await drawProductData())
    waitAndDraw()
    // waitAndDraw()
}
// console.log("Draw Layout Promise")
// console.log("Listen to Interaction Promse")
// waitAndDraw()
// waitAndDraw()
