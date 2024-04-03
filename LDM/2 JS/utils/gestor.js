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

primerEjercicio();
segundoEjercicio();
tercerEjercicio();

function primerEjercicio() {
    buttonPrimero.addEventListener("click", () => {
        outputPrimero.innerHTML="";
        let numero = parseInt(numeroPrimero.value);
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
