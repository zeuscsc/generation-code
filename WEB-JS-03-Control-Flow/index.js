//Part 1
function businessHours(dayNumber, hourNumber) {
    if (dayNumber === 0 || dayNumber === 6)
        return false
    else {
        if (hourNumber >= 9 && hourNumber < 18)
            return true
        else
            return false
    }
}

function part1TestCase() {
    console.log(businessHours(0, 0) === false)
    console.log(businessHours(1, 9) === true)
    console.log(businessHours(1, 17) === true)
    console.log(businessHours(1, 18) === false)
    console.log(businessHours(6, 9) === false)
    console.log(businessHours(6, 17) === false)
}
// part1TestCase();

//Part 2
function getDayNumber(janFirstDayNumber, yearDayNumber) {
    return (yearDayNumber + janFirstDayNumber) % 7
}

function part2TestCase() {
    console.log(getDayNumber(0, 1) === 1)
    console.log(getDayNumber(0, 6) === 6)
    console.log(getDayNumber(0, 7) === 0)
    console.log(getDayNumber(1, 1) === 2)
    console.log(getDayNumber(1, 6) === 0)
    console.log(getDayNumber(1, 7) === 1)
    console.log(getDayNumber(5, 271) === 3)
}
// part2TestCase();

//Part 3
function businessHoursYear(janFirstDayNumber, yearDayNumber, hourNumber) {
    dayNumber = getDayNumber(janFirstDayNumber, yearDayNumber)
    return businessHours(dayNumber, hourNumber)
}
function part3TestCase() {
    console.log(businessHoursYear(0, 0, 9) === false)
    console.log(businessHoursYear(5, 271, 9) === true)
    console.log(businessHoursYear(5, 271, 18) === false)
}
part3TestCase();