function hola(nombre, miCallback){
    setTimeout( function (){
        console.log('Hola '+nombre);
        miCallback(nombre);
    },1000);
}

function hablar(callbackHablar){
    setTimeout( function () {
        console.log('bla bla bla bla');
        callbackHablar();
    }, 1000);
}

function adios(nombre, otroCallback) {
    setTimeout(function (){
        console.log('Adios '+ nombre);
        otroCallback()
    }, 1000);
}

//-- Proceso princimal
console.log('Iniciando el proceso...')
hola('Carlos', function(nombre) {
    adios(nombre, function() {
        console.log('Termino el proceso...');
    });
});