# SELENIUM_JAVA_POM_2

to run on command line:
mvn clean test -DsuiteName=${suite name} -Dbrowser=${browser name}

example:
mvn clean test -DsuiteName=failed -Dbrowser=EDGE

EJERCICIOS URL: https://www.saucedemo.com/

EJERCICIO 1

1. Ir al index
2. Poner usuario y contraseña correctos a. standard_user b. secret_sauce
3. Hacer clic en login
4. Verificar que llegues a la pantalla de shopping
5. Hacer clic en el menú arriba izquierda
6. Hacer clic en logout
7. Verificar que te regrese a la pantalla de login

EJERCICIO 2

1. Ir al index
2. Poner usuario y contraseña correctos a. standard_user b. secret_sauce
3. Hacer clic en login
4. Verificar que llegues a la pantalla de shopping
5. Hacer clic en el menú arriba izquierda
6. Verificar que el botón about te mande a la página de saucelabs

EJERCICIO 3

1. Ir al index
2. Poner usuario y contraseña bloqueados a. locked_out_user b. secret_sauce
3. Hacer clic en login
4. Verificar que salga el mensaje de que el usuario ha sido bloqueado

EJERCICIO 4

1. Ir al index
2. Poner usuario y contraseña correctos a. standard_user b. secret_sauce
3. Verificar que llegues a la pantalla de shopping
4. Agregar 4 productos al carrito entrando al detalle de este (leer desde excel)
5. Verificar que el numero arriba derecha coincida con el # de ítems en el carrito
6. Ir al checkout
7. Verificar que se abra la ventana del checkout
8. Hacer click en el checkout
9. Verificar que se abra la ventana de llenar tus datos
10. Ingresar firstname, lastname y zipcode (creados de forma aleatoria)
11. Presionar continue
12. Verificar que llegues a la ventana del finish checkout
13. Coger el total y verificar que coincida con la suma de cada item
14. Hacer clic en finish
15. Verificar el mensaje de éxito
16. Presionar back to home
17. Verificar que te regrese al home

Bonus: correr lo mismo pero con el locket out user y performance glitch user
