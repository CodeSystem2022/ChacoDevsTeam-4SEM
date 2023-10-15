function hola(nombre, miCallback){
    setTimeout( function (){
        console.log('Hola '+nombre);
        miCallback();
    },1000);
}

function adios(nombre, otroCallback) {
    setTimeout(function (){
        console.log('Adios', nombre);
        otroCallback()
    }, 1000);
}

console.log('Iniciando el proceso...')
hola('Carlos', function(){
    adios('Carlos', function() {
        console.log('Termino el proceso...');
    });
});
