function hola(nombre){
    return new Promise(function (resolve, reject) {
        setTimeout( function (){
            console.log('Hola '+nombre);
            resolve(nombre);
        }, 1000);
    });
    
}

function hablar(callbackHablar){
    setTimeout( function () {
        console.log('bla bla bla bla');
        callbackHablar();
    }, 1000);
}

function adios(nombre) {
    return new Promise( (resolve, reject) => {
        setTimeout( function() {
            console.log('Adios '+ nombre);
            resolve()
        }, 1000);
    })

}

//Llamamos a la funcion 
console.log('Iniciando el proceso...');
hola('Ariel')
    .then(adios)
    .then((nombre) => {
        console.log('Terminando el proceso');
    })