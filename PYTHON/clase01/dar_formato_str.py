# dar formato a un string

nombre = 'Ariel'
edad = 28
mensaje_con_formato = 'Mi nombre es %s y tengo %d años' % (nombre, edad)

persona = ('Carla', 'Gomez', 5000.00)
mensaje_con_formato = 'Hola %s %S . Tu sueldo es %.2f' # % persona Aqui le pasamos el objeto que es tupla.
print(mensaje_con_formato % persona)