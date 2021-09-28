const GENERATION_FACTOR = 1
let generationStudentScore
let generation_student_score
let x = 0;
let a = 3;
// function foo(a) {
//     x = x + (a + 1);
//     x = x - a;
//     x = x ** a
//     x = Math.pow(x, (1.0 / a))
//     console.log(x)
// }
function loop() {
    // for (let i = 0; i < 10; i++) {
    //     foo(a);
    // }
    foo(a); foo(a); foo(a); foo(a); foo(a); foo(a); foo(a); foo(a); foo(a); foo(a);
}
let foo = (a) => {
    x = x + (a + 1);
    x = x - a;
    x = x ** a;
    x = Math.pow(x, (1.0 / a));
    console.log(x);
}
loop();