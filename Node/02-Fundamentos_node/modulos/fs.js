const fs = require('fs');

//Primero leemos el archivo.txt
function leer(ruta,cb){
     fs.readFile(ruta,(err,data)=>
    {
        cb(data.toString())
    })
}
   

leer(`${__dirname}/archivo.txt`,console.log)


