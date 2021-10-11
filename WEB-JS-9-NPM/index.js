// const axios = require('axios')

// const getBreeds = async () => {
//     try {
//         return await axios.get('https://dog.ceo/api/breeds/list/all')
//     } catch (error) {
//         console.error(error)
//     }
// }

// const countBreeds = async () => {
//     const breeds = await getBreeds()

//     if (breeds.data.message) {
//         console.log(`Got ${Object.entries(breeds.data.message).length} breeds`)
//     }
// }

// countBreeds()
import fetch from 'node-fetch';

async function getBreeds() {
    const response = await fetch('https://dog.ceo/api/breeds/list/all');
    const data = await response.json();
    return data
};
async function countBreeds() {
    const breeds = await getBreeds()

    if (breeds.message) {
        console.log(`Got ${Object.entries(breeds.message).length} breeds`)
    }
}
countBreeds();
