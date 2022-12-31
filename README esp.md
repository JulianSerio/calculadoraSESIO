# CALCULADORA SESIO
#### Video Demo:  <[URL HERE](https://youtube.com/shorts/cwJG_G-D6ME)>
#### Description: 

Mi proyecto es una calculadora simple, la cual tiene las funciones basicas (que se pueda dividir, multiplicar, sumar, restar, borrar operaciones y numeros), pero con una funcion que te permita saber cual va a ser el valor de una compra en dolares en el exterior, en mi pais Argentina hay impuestos establecidos para las compras en dolares en el exterior, en plataformas digitales como Steam, Amazon, Google Play Store, etc, por esto me parecio algo muy util tener una calculadora que te permita saber cuanto es el monto total de la compra.

Lo primero que empece por definir en mi aplicacion son sus funciones, necesitaba: una funcion para __borrar un caracter__, para __borrar la operacion__ (estas 2 operaciones estan contenidas en cualquier calculadora moderna), y un __boton que te lleve a otra vista__ en la cual a travez de un input de un valor en dolares se calculen los impuestos que son agregados para una compra fuera de Argentina.

Para el diseño (los colores, formas, botones, etc) busque referencias acerca de diseños de calculadoras que hoy en dia todos tenemos instaladas en nuestros celulares, luego diseñe un esquema __top-down__ en cual descompuse mi aplicacion en sus distintas funciones para poder esquematizarla mejor.

<ins>activity_main.xml</ins>

Para poder trabajar de forma mas comoda con los botones decidi poner __Guidelines__ (verticales y horizontales), de esta manera no tendremos problema a la hora de acomodar los elementos y que queden alineandos. Luego enlazo los guidelines con los texviews y los botones, estableci el tamaño del __Textview__ por la cual se ven los resultados, y aumente el tamaño del texto.
El siguiente paso fue realizar los botones, configure el tamaño de los mismos dependiendo del diseño que previamente habia planteado, ademas ubique en que lugar deberian ir las operaciones, el boton para borrar un caracter y la operacion y para pasar a la siguiente vista donde realizo el calculo de impuestos.

El siguiente paso fue establecer los metodos __OnClick__ a los se que debe responder cada vez que se preciona un boton, ejemplo: cada vez que se preciona el numero 0 que escriba ese numero en la pantalla, y asi con los demas, para los metodos de las operaciones decidi que cada vez que se preciona un boton, ya sea dividir, multiplicar, sumar o restar guarde un __simbolo__(÷, x, + y -);
Lo mismo hice con los botones de limpieza (__C__ y __DELETE__), les asigne un metodo OnClick, limpiarTv y borrar, luego al boton __DOLAR__ su metodo solo pasa a la vista Taxes.
 
<ins>Main_Activity.java</ins>

Aqui me encargue de la parte logica de la calculadora, utilizando los id's que previamente habia declarado vincule la vista con la logica de mi aplicacion; cree las variables que van a guardar ambos numeros y la operacion que se quiere llevar a cabo, para los numeros decidi utilizar el tipo Float para tambien almacenar numero con coma y las inicialize en 0. Aqui tambien implemente los metodos OnClick a los que responden los botones, cada vez que se preciona alguno de los numeros se pregunta si ya habia algo escrito en tvRes (la pantalla de la calculadora), si hay se concatena con el nuevo numero ingresado, sino se agrega el numero nuevo, por ejemplo en el metodo __"escribirCero"__ cada vez que se presione __0__ se envia al __tvRes__ ese numero, y asi con los demas metodos que escriben numeros; para almacenar la operacion decidi utilizar un String ya que lo que se va a guardar son simbolos de las operaciones, por ejemplo: cada vez que se preciona el metodo __sumar__ a la variable __op__ se le asigna el string __"+"__ y asi con las demas. 

Para el metodo __limpiarTv__ (borrar todo): asigno a todas las variables el __valor 0__ y al string op el __valor vacio__ (""), luego hago que el tvRes vuelva a su __valor inicial__ (0), y en el caso de Borrar (borrar ultimo caracter) fue mas complicado ya que debia obtener la cadena de numeros y borrar el ultimo valor, lo que hice fue crear una variable auxiliar llamada text la cual toma el valor de todos los numeros actuales de la pantalla (este es una succesion de valores por lo tanto es un array) y luego acorto la longitud del arreglo en 1, de esta forma estoy __eliminando el ultimo numero ingresado__.

Lo siguiente a realizar es el metodo __Igual__ en el cual concrete todas las operaciones y aplico ese resultado al tvRes. Me parecio mas dinamico utilizar if's anidados para preguntar sobre el valor contenido dentro de la variable __op__ (-,+,x,÷) y __realizo la operacion__ entre ambos numeros previamente almacenados en sus respectivas variables. Ademas aqui tambien necesitaba de alguna forma para realizar un rendondeo en el numero resultante, para ello utilice la clase __BigDecimal__, es una clase de Java para representar números con coma flotante de manera precisa.

El ultimo paso fue hacer el metodo para el __punto__ en el cual lo unico que hace es __concatenar la anterior__ escrito en el tvRes con un punto (.) y el metodo para pasar ah la siguiente vista (Taxes) en la cual utilice el objeto __Intent__, una Intent es un objeto de mensajería que puedes usar para solicitar una acción de otro componente de una app.

<ins>activity_taxes.xml</ins>

Al igual que en la vista Main previa a su implementacion decidi realizar un esquema top-down sobre de las funciones que debian implementarse en Taxes, en Argentina tenemos __2 tipos de impuestos__ que son aplicados a compras online en el exterior, __Impuesto Pais__ e __Impuesto a las Ganancias__, cada uno con sus porcentajes de valores agregados (es decir: si tenemos una compra de __10__ dolares, actualmente sin impuestos serian __$1790__ pesos, el Impuesto Pais (30%) de esta compra son: __$537__ y de el Impuesto a las Ganancias (45%) es: __$805,5__ pesos, el total de esta compra seria, en pesos, __$3132,5__) por esto me parecio necesario mostrar estos valores a la hora de calcular un valor, el valor base en pesos, cuanto se agregan de ambos impuestos y el total que se facturaria. 

Para empezar cree un boton el cual te permite __volver a Main__, y otro boton para __Calcular__ el valor de los dolares ingresados. Luego cree los __distintos textviews__ para mostrar los valores correspondientes, ademas de un EditText para realizar el ingreso del monto a calcular.

<ins>Taxes.java</ins>

Despues de vincular la logica con las diferentes vistas en la cual se muestran los montos, realice un metodo que __vuelve a Main__ tambien usando la clase Intent. 
Luego hice el metodo al cual responde el boton __Calcular__, en el cual estableci el valor actual del dolar en Argetina, el porcentaje de Impuesto Pais y de Impuesto a las Ganancias, luego obtengo el valor ingresado con et (EditText), el siguiente paso es realizar los calculos para saber cuanto se agrega de cada impuesto utilizando la siguiente formula ``(((Monto de dolares / 100) * porcentaje del impuesto) * precio de un Dolar))``, y despues la suma total. 

Por ultimo muestro los valores en sus __TextViews__ correspondientes.

<ins>Otro Archivos<ins>

+ AndroidManifest.xml

    En este archivo lo unico que modifique fue la orientacion de las vistas para que cuando se tenga activa la opcion para poner la aplicacion de forma horizontal.

+ ic_Launcher
  
    Pesonalice un icono para mi aplicacion, el cual aparece como logo principal y en la vista Main.
