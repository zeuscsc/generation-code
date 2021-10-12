const asyncSum = require("./async")

test("Async 1+1=2", async () => {
    let ans = await asyncSum(1, 1);
    expect(ans).toBe(2)
})

// test("Async 1+1=2 is fast enough", async () => {
//     let start = Date.now();
//     await asyncSum(1, 1);
//     let end = Date.now();
//     let duration = end - start;
//     expect(duration).toBeLessThanOrEqual(500);
// })