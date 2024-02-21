let inputNombre = document.querySelector("input#input-nombre");
let inputApellido = document.querySelector("input#input-apellido");
let inputEmail =document.querySelector("input#input-email");
let inputDepartamento = document.querySelector("#departamento");
let inputBuscar =document.querySelector("input#input-buscar");
let boton = document.querySelector("#boton-confirmar");
let listaUsuarios = document.querySelector("#lista-usuarios");
let listaBuscar = document.querySelector("#lista-busqueda");
let listaUsuariosDatos = [];
let listaTrabajadores = document.querySelector("#lista-trabajadores");
let it = document.querySelector("#it");
let marketing = document.querySelector("#marketing");
let ventas = document.querySelector("#ventas");
let administracion = document.querySelector("#administracion");


/* boton.addEventListener("click", () => {
    if(inputNombre.value.length > 0 && 
        inputApellido.value.length > 0 && 
        inputEmail.value.length > 0 && 
        inputDepartamento.value !== "Escoje al departamento al que perteneces") {
            listaUsuariosDatos.push(`${inputNombre.value} ${inputApellido.value} 
                ${inputEmail.value} ${inputDepartamento.value}`);
            let nodo = document.createElement("li");
            
            nodo.textContent = `${inputNombre.value} ${inputApellido.value} 
            ${inputEmail.value} ${inputDepartamento.value}`;
            nodo.className = "animate__animated animate__zoomInUp list-group-item";
            listaTrabajadores.append(nodo);
            inputNombre.value = "";
            inputApellido.value = "";
            inputEmail.value = "";
            inputDepartamento.value = "Escoje al departamento al que perteneces";
            console.log(listaUsuariosDatos);
            
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
}); */
boton.addEventListener("click", () => {
    // Verificamos que se hayan ingresado todos los datos necesarios
    if (
        inputNombre.value.length > 0 &&
        inputApellido.value.length > 0 &&
        inputEmail.value.length > 0 &&
        inputDepartamento.value !== "Escoje al departamento al que perteneces"
    ) {
        // Creamos el usuario con los datos ingresados
        let usuario = {
            nombre: inputNombre.value,
            apellido: inputApellido.value,
            email: inputEmail.value,
            departamento: inputDepartamento.value
        };

        // Agregar el usuario al array listaUsuariosDatos
        listaUsuariosDatos.push(usuario);

        // Actualizar la lista de trabajadores generales
        actualizarListaTrabajadores();

        // Actualizar la lista de trabajadores por departamento
        actualizarTrabajadoresPorDepartamento();

        // Limpiar el formulario
        inputNombre.value = "";
        inputApellido.value = "";
        inputEmail.value = "";
        inputDepartamento.value = "Escoje al departamento al que perteneces";

        // Mostrar un mensaje de éxito si fue todo bien
        Swal.fire({
            title: '¡Correcto!',
            text: 'Usuario agregado correctamente',
            icon: 'success',
            confirmButtonText: 'Gracias',
            timer: 2000
        });
    } else {
        // Mostrar un mensaje de error si falta algún dato
        Swal.fire({
            title: '¡Error!',
            text: 'Falta algún dato',
            icon: 'error',
            confirmButtonText: 'Probar de nuevo',
            timer: 2000
        });
    }
});

// Función para actualizar la lista de trabajadores generales
function actualizarListaTrabajadores() {
    listaTrabajadores.innerHTML = "";
    listaUsuariosDatos.forEach(usuario => {
        let nodo = document.createElement("li");
        nodo.textContent = `${usuario.nombre} ${usuario.apellido} ${usuario.email} - ${usuario.departamento}`;
        nodo.className = "list-group-item";
        listaTrabajadores.append(nodo);
    });
}

// Función para actualizar la lista de trabajadores por departamento
function actualizarTrabajadoresPorDepartamento() {
    // Recorrer la lista de usuarios
    listaUsuariosDatos.forEach(usuario => {
        let nodo = document.createElement("li");
        nodo.textContent = `${usuario.nombre} ${usuario.apellido}`;
        nodo.className = "list-group-item";
        if(inputDepartamento.value=="IT") {
            it.append(nodo);
        }
        if(inputDepartamento.value=="Marketing") {
            marketing.append(nodo);
        }
        if(inputDepartamento.value=="Ventas") {
            ventas.append(nodo);
        }
        if(inputDepartamento.value=="Administración") {
            administracion.append(nodo);
        }
        
    });
}