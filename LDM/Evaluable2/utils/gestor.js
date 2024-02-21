let inputNombre = document.querySelector("input#input-nombre");
let inputApellido = document.querySelector("input#input-apellido");
let inputEmail =document.querySelector("input#input-email");
let inputDepartamento = document.querySelector("#departamento");

let boton = document.querySelector("#boton-confirmar");
let listaUsuarios = document.querySelector("#lista-usuarios");

boton.addEventListener("click", () => {
    // console.log(inputNombre.value);
    // console.log(inputApellido.value);
    if(inputNombre.value.length > 0 && 
        inputApellido.value.length > 0 && 
        inputEmail.value.length > 0 && 
        inputDepartamento.value !== "Escoje al departamento al que perteneces") {
            listaUsuarios.innerHTML += `<li class='animate__animated animate__zoomInUp list-group-item'>${inputNombre.value} ${inputApellido.value} 
                ${inputEmail.value} ${inputDepartamento.value}</li>`;
            inputNombre.value = "";
            inputApellido.value = "";
            inputEmail.value = "";
            inputDepartamento.value = "";
    } else {
        alert("No se puede añadir"); 
}
});