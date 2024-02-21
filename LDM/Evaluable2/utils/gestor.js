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
            let nodo = document.createElement("li");
            nodo.textContent = `${inputNombre.value} ${inputApellido.value} 
            ${inputEmail.value} ${inputDepartamento.value}`;
            nodo.className = "animate__animated animate__zoomInUp list-group-item";
            listaUsuarios.append(nodo);

            /* listaUsuarios.innerHTML += `<li class='animate__animated animate__zoomInUp list-group-item'>${inputNombre.value} ${inputApellido.value} 
                ${inputEmail.value} ${inputDepartamento.value}</li>`; */
            inputNombre.value = "";
            inputApellido.value = "";
            inputEmail.value = "";
            inputDepartamento.value = "Escoje al departamento al que perteneces";
            
        Swal.fire({
            title: '¡Correcto!',
            text: 'Usuario agregado correctamente',
            icon: 'success',
            confirmButtonText: 'Gracias',
            timer: 2000
              })
    } else {
        Swal.fire({
            title: '¡Error!',
            text: 'Falta algún dato',
            icon: 'error',
            confirmButtonText: 'Probar de nuevo',
            timer: 2000
          })
}
});