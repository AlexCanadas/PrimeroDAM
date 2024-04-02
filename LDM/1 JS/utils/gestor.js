let input = document.querySelector("#input-numero");
let output = document.querySelector("#output");

let inputDos = document.querySelector("#input-numeroDos");
let numerosPares = document.querySelector("#numeros-pares");
let numerosImpares = document.querySelector("#numeros-impares");

let inputString = document.querySelector("#inputString");
let outputString = document.querySelector("#outputString");

let inputStringDos = document.querySelector("#inputStringDos");
let outputStringDos = document.querySelector("#outputStringDos");

let outputRandom = document.querySelector("#outputRandom");

primerEjercicio();
segundoEjercicio();
tercerEjercicio();
cuartoEjercicio();

function primerEjercicio() { 
    input.addEventListener("input", function() {
    let numero = parseInt(input.value);

        if(numero % 2 == 0) {
            let nodo = document.createElement("plaintext");
            nodo.textContent="Número par";
            output.innerHTML="";
            output.append(nodo);
        } else {
            let nodo=document.createElement("plaintext");
            nodo.textContent="Número impar";
            output.innerHTML="";
            output.append(nodo);
        }
    });
}

function segundoEjercicio() {
    inputDos.addEventListener("input", function() {
    let numeroDos = parseInt(inputDos.value);
    numerosPares.innerHTML="";
    numerosImpares.innerHTML="";

        for (let i=numeroDos; i<numeroDos+20; i++) {
            if (i % 2 == 0) {
            let nodo = document.createElement("li")
            nodo.textContent="Número " + i
            numerosPares.append(nodo);
            }else {
                let nodoDos =document.createElement("li")
                nodoDos.textContent="Número " +i
                numerosImpares.append(nodoDos);
            }
        }
        });
}

function tercerEjercicio() {
    inputString.addEventListener("input", function() {
        let cadena = inputString.value;

        if (cadena===cadena.toUpperCase()) {
            outputString.textContent="La cadena solo contiene mayúsculas";
        }
        else if (cadena===cadena.toLowerCase()) {
            outputString.textContent="La cadena solo contiene minúsculas";
        }
        else {
            outputString.textContent="La cadena no está formada solo por mayúsculas O minúsculas"
        }
    });
}

function cuartoEjercicio() {
    inputStringDos.addEventListener("input", function() {
        let cadenaDos = inputStringDos.value;
        let cadenaModificada=cadenaDos.replace(/ /g, '/');
        outputStringDos.textContent = cadenaModificada;
    });
}

console.log(outputStringDos)


