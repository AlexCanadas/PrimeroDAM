let numeroPrimero = document.getElementById("numeroPrimero");
let buttonPrimero = document.getElementById("buttonPrimero");
let outputPrimero = document.getElementById("outputPrimero");

let numeroSegundo = document.getElementById("numeroSegundo");
let outputSegundo = document.getElementById("outputSegundo");
let botonCheck = document.getElementById("botonCheck");
let botonClear = document.getElementById("botonClear");

let botonAzul = document.getElementById("botonAzul");
let botonGris = document.getElementById("botonGris");
let botonVerde = document.getElementById("botonVerde");
let botonRojo = document.getElementById("botonRojo");
let botonAmarillo = document.getElementById("botonAmarillo");

let nombre = document.getElementById("nombre");
let apellidos = document.getElementById("apellidos");
let localidad = document.getElementById("localidad");
let email = document.getElementById("email");
let edad = document.getElementById("edad");
let botonDatos = document.getElementById("botonDatos");
let botonReset = document.getElementById("botonReset");
let outputDatos = document.getElementById("outputDatos");

let botonDias = document.getElementById("botonDias");

primerEjercicio();
segundoEjercicio();
tercerEjercicio();
cuartoEjercicio();
quintoEjercicio();

function primerEjercicio() {
    buttonPrimero.addEventListener("click", () => {
        outputPrimero.innerHTML="";
        let numero = parseInt(numeroPrimero.value);
            // Verificar si se ha ingresado un número entero válido
            if (isNaN(numero)) {
                outputPrimero.innerHTML=`Por favor, introduce un número entero.`;
                return;
            }
            if (numero<=2) {
                let nodo = `El número ${numero} no es primo`
                outputPrimero.append(nodo);
            }
            else if (numero % 2===0) {
                let nodo = `El número ${numero} es primo`
                outputPrimero.append(nodo);
            }
            else {
                let nodo = `El número ${numero} no es primo`
                outputPrimero.append(nodo);
            }
    });
}

function segundoEjercicio() {
botonCheck.addEventListener("click", () => {
let numero = parseInt(numeroSegundo.value);
let nodo = (numero * 1.8) + 32;
outputSegundo.textContent=`${numero}ºC in Celsius is equivalent to ${nodo}ºF in Fahrenheit.`;
});
botonClear.addEventListener("click", () => {
numeroSegundo.value="";
outputSegundo.innerHTML="";
});
}

function tercerEjercicio() {
    botonAzul.addEventListener("click", () => {

    });
    botonGris.addEventListener("click", () => {

    });
    botonVerde.addEventListener("click", () => {

    });
    botonRojo.addEventListener("click", () => {

    });
    botonAmarillo.addEventListener("click", () => {

    });
}

function cuartoEjercicio() {
    botonDatos.addEventListener("click",() => {
        let usuario = {
            nombre : nombre.value,
            apellido : apellidos.value,
            localidad : localidad.value,
            email : email.value,
            //edad : edad.value NO FUNCIONA DROPDOWN
        };
    let toString = JSON.stringify(usuario);
    alert(toString);
    });

    botonReset.addEventListener("click",() => {
        nombre.value="";
        apellidos.value="";
        localidad.value="";
        email.value="";
    });
}

function quintoEjercicio() {
    botonDias.addEventListener("click",() => {
        let nombre = prompt("Por favor, introduce tu nombre:");
        let edad = prompt("Hola " + nombre + ", ¿cuántos años tienes?");
        // Verificar si se ha ingresado un número válido como edad
        while (isNaN(edad) || edad <= 0) {
            edad = prompt("Por favor, introduce una edad válida:");
        }

        const diasAno = 365; 
        const diasVividos = Math.floor(edad * diasAno);

        // Calcular y mostrar los días vividos
        let resultado = `${nombre}, has vivido aproximadamente ${diasVividos} días.`;
        alert(resultado);
    });
}