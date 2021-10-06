let body = document.body
body.className = "day"
let input = document.createElement("input")
let h1 = document.createElement("h1")
let button = document.createElement("button");
button.className = "awsome"
body.appendChild(h1)
body.appendChild(input)
body.appendChild(button)
// function onInputChanged(event) {
//     h1.textContent = event.target.value
// }
// input.addEventListener("input", onInputChanged)
// input.addEventListener("input", onInputChanged)
// input.addEventListener("input", onInputChanged)
// input.addEventListener("input", onInputChanged)
input.addEventListener("input", (e) => {
    h1.textContent = e.target.value
})
button.addEventListener("mouseenter", (e) => {
    button.classList.add("focus")
    // let btn = document.createElement("button");
    // btn.className = "awsome"
    // button.btn = btn
    body.appendChild(input.cloneNode())
    // const btn_str = "<button class='awsome focus'></button>"
    // body.innerHTML += "<input>"
    console.log(document.querySelectorAll(".awsome.focus"))
})
button.addEventListener("mouseleave", (e) => {
    button.classList.remove("focus")
    // body.removeChild(button.btn)
})
// window.addEventListener('load', (event) => {
// });
let imagesURL = [
    `https://wallpapercave.com/wp/wp3136211.jpg`,
    `https://wallpapercave.com/wp/wp3136212.jpg`,
    `https://wallpapercave.com/wp/wp3136214.jpg`,
    `https://wallpapercave.com/wp/wp3136215.jpg`
]
let json =
    [
        {
            image: `https://wallpapercave.com/wp/wp3136211.jpg`,
            search: `a`
        },
        {
            image: `https://wallpapercave.com/wp/wp3136212.jpg`,
            search: `b`
        },
        {
            image: `https://wallpapercave.com/wp/wp3136214.jpg`,
            search: `c`
        },
        {
            image: `https://wallpapercave.com/wp/wp3136215.jpg`,
            search: `d`
        },
    ]

console.log(window.location.search)
const params = new URLSearchParams(window.location.search)
// console.log(params.keys(), params.values())
console.log(params.get("id"))
let div = document.createElement("div");
body.appendChild(div)
for (let item of json) {
    let image = document.createElement("img");
    image.className = "awsome"
    image.src = item.image
    image.addEventListener("click", (e) => {
        // alert("Really wants to go to:" + url)
        // window.location = `https://www.google.com/search?q=${item.search}`;
    })
    div.appendChild(image);

    // const image = `<a href="${url}"><img class="awsome"
    //  src="${url}"</a>`
    // div.innerHTML += image
}
let awsomes = document.querySelectorAll(".awsome")
console.log(awsomes)