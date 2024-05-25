let nombre = document.getElementById("nombre");
let edad = document.getElementById("edad");
let boton = document.getElementById("boton");
let output = document.getElementById("output");

boton.addEventListener("click", () => {
    let nombreValue = nombre.value;
    let edadValue = edad.value;

    output.innerHTML += `
    <div class="col-4">
        <div class="card mt-3" style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${nombreValue}</h5>
                <p class="card-text">${edadValue}</p>
            </div>
        </div>
    </div>
    `
    nombre.value="";
    edad.value="";

    });;
