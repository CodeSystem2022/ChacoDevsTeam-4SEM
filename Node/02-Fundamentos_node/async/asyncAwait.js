async function hola(nombre) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            console.log('Hola ' + nombre);
            resolve(nombre);
        }, 1000);
    });

}

function hablar(nombre) {
    return new Promise((resolve, reject) => { //usamos la sintaxis ES6
        setTimeout(function () {
            console.log('bla bla bla bla');
            resolve(nombre);
        }, 1000);
    });
}

async function adios(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(function () {
            console.log('Adios ' + nombre);
            //resolve();
            reject('Hay un error');
        }, 1000);
    });
}

//await hola('Ariel'); //Esto es una mala sintaxis

async function main(){
    let nombre = await hola('Ariel');
    await hablar();
    await hablar();
    await hablar();
    await adios(nombre);
}

main();