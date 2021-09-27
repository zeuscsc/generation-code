// <input id="a">
// document.querySelector("#a");
// <input class="b">
// document.querySelector(".b");
// <input>
// document.querySelector("input");
// let input = document.querySelector("input");
// input.value = "Foobar";
// let button = document.querySelector("button");
// button.addEventListener("click", (event) => {
//     console.log(event);
//     input.value = "button";
// })

// Calculator
let a = document.querySelector("#a");
let b = document.querySelector("#b");
let b0 = document.querySelector("#b0");
let b1 = document.querySelector("#b1");
let equal = document.querySelector("#equal");
let sum = document.querySelector("#sum");
let output = document.querySelector("#output");
let binaryOutput = document.querySelector("#binaryOutput");
let result = ""
let stack = 0
b0.addEventListener("click", (e) => {
    result = result + "0";
    output.textContent = parseInt(result, 2);
    binaryOutput.textContent = result;
})
b1.addEventListener("click", (e) => {
    result = result + "1";
    output.textContent = parseInt(result, 2);
    binaryOutput.textContent = result;
})
equal.addEventListener("click", (e) => {
    console.log(stack)
    stack = parseInt(stack, 2) + parseInt(result, 2)
    console.log(stack)
    output.textContent = stack;
    // binaryOutput.textContent = parseInt(stack);
})
sum.addEventListener("click", (e) => {
    stack = stack + result
    result = ""
    output.textContent = parseInt(a.value) + parseInt(b.value)
})
document.addEventListener("mousedown", (e) => {
    if (e.button === 2) {
        e.preventDefault();
        console.log(e);
        alert("No copy nor inspect")
    }
})
document.addEventListener("mousemove", (e) => {
    console.log(e)
})