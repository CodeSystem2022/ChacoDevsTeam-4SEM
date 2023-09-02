console.log('Inicio del programa');// 1

setTimeout(() => {
    console.log('Primer Timeout');// 5
},3000);

setTimeout(() => {
    console.log('Segundo Timeout');// 3
},0);

setTimeout(() => {
    console.log('Tercero Timeout');// 4
},0);

console.log('Fin del programa');// 2