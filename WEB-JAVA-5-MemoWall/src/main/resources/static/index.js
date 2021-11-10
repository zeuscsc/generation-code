let form = document.querySelector("#add-form");
let memos = [{ message: "hello world" }]
form.addEventListener("submit", async (e) => {
    e.preventDefault();
    let memo_content = document.querySelector("#memo_content");
    memos.push({ message: memo_content.value })
    await addMemo(memo_content.value);
    updateMemo();
})
async function addMemo(content) {
    let token = localStorage.getItem("token");
    if (token) {
        let res = await fetch("http://localhost:8081/memos/add", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify({ "content": content })
        });
        console.log(await res.json());
    } else {
        //Login First
    }
}
async function getMemos() {
    let res = await fetch("http://localhost:8081/memos/all");
    let memos = await res.json();
    return memos;
}
async function updateMemo() {
    let memos = await getMemos();
    let postits = document.querySelector("#postits");
    postits.innerHTML = "";
    for (let memo of memos) {
        postits.innerHTML += `
            <div class="col-sm-3 col-12 postit">
                <img class="memo" id="postit" src="postit.png">
                <button class="edit edit_button" data-id=0><i class="fas fa-edit"></i></button>
                <div class="memoCentered">
                    <h5 id="memoEditDisplayText">${memo.content}</h5>
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
let loginForm = document.querySelector("#login");
loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    let username = e.currentTarget.querySelector("#username").value
    let password = e.currentTarget.querySelector("#password").value
    await login(username, password)
})
async function login(username, password) {
    let res = await fetch("http://localhost:8081/authenticate", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username: username, password: password })
    })
    let json = await res.json();
    console.log(json)
    if (json.token) {
        let token = json.token;
        localStorage.setItem("token", token);
    } else if (json.status && json.status === 401) {
        //Wrong Password
    }
}
updateMemo();
