let input = document.querySelector("#input-numero");
let output = document.querySelector("#output");

let inputDos = document.querySelector("#input-numeroDos");
let numerosPares = document.querySelector("#numeros-pares");
let numerosImpares = document.querySelector("#numeros-impares");
let paresQty = document.querySelector("#paresQty");
let imparesQty = document.querySelector("#imparesQty");

let buttonTres = document.querySelector("#buttonTres");
let outputString = document.querySelector("#outputString");

let inputStringDos = document.querySelector("#inputStringDos");
let outputStringDos = document.querySelector("#outputStringDos");

let numMayor = document.querySelector("#numMayor");
let numMenor = document.querySelector("#numMenor");
let mayores = document.querySelector("#mayores");
let menores = document.querySelector("#menores");
let buttonCinco = document.querySelector("#buttonCinco");

primerEjercicio();
segundoEjercicio();
tercerEjercicio();
cuartoEjercicio();
quintoEjercicio();

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
        
        // Contamos y mostramos
        paresQty.textContent = numerosPares.children.length;
        imparesQty.textContent = numerosImpares.children.length;
        });
}

function tercerEjercicio() {
    buttonTres.addEventListener("click", async function() {
        let cadena = await pedirCadena();

        if (cadena===cadena.toUpperCase()) {
            outputString.textContent="La cadena solo contiene mayúsculas";
            outputString.classList.add("animate__animated", "animate__rollIn", "list-group-item");
        }
        else if (cadena===cadena.toLowerCase()) {
            outputString.textContent="La cadena solo contiene minúsculas";
            outputString.classList.add("animate__animated", "animate__rollIn", "list-group-item");
        }
        else {
            outputString.textContent="La cadena no está formada solo por mayúsculas O minúsculas"
            outputString.classList.add("animate__animated", "animate__rollIn", "list-group-item");
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

function quintoEjercicio() {
    buttonCinco.addEventListener("click", () => {
        
    let numeros =[];
    let num_menor = 0;
    let num_mayor = 0;
    for (let i=0; i<=10; i++) {
    let numRandom = Math.floor(Math.random()*50+1);
    numeros.push(numRandom);
        if (numRandom<25) {
            num_menor++;
        }
        else {
           num_mayor++;
        }
    }
    // Agregar resultados a las tablas, primero limpiamos
    numMenor.innerHTML="";
    numMayor.innerHTML="";

    numeros.forEach(numero => {
        if (numero < 25) {
            let nodo = document.createElement("li");
            nodo.textContent = numero;
            numMenor.append(nodo);
        } else {
            let nodo = document.createElement("li");
            nodo.textContent = numero;
            numMayor.append(nodo);
        }
    });

    // Actualizar contadores
    mayores.textContent = `Números mayores de 25: ${num_mayor}`;
    menores.textContent = `Números menores o igual a 25: ${num_menor}`;
    });
}

async function pedirCadena() {
    const { value: texto } = await Swal.fire({
        input: "textarea",
        inputLabel: "Message",
        inputPlaceholder: "Type your message here...",
        inputAttributes: {
          "aria-label": "Type your message here"
        },
        showCancelButton: true
      });
      return texto;
}



