let nombre = document.getElementById("nombre");
let apellido = document.getElementById("apellido");
let correo = document.getElementById("correo");
let contraseña = document.getElementById("contraseña");
let boton = document.getElementById("boton");

boton.addEventListener("click", (event) => {
    event.preventDefault();
    let nombreValue = nombre.value;
    let apellidoValue = apellido.value;
    let correovalue = correo.value;
    let contraseñaValue = contraseña.value;
    
    output.innerHTML += `
    <div class="resultado">
                    <h2>Datos del Formulario</h3>
                    <p><strong>Nombre:</strong> ${nombreValue.nombre}</p>
                    <p><strong>Email:</strong> ${apellidoValue.email}</p>
                    <p><strong>Teléfono:</strong> ${correovalue.telefono}</p>
                    <p><strong>Web:</strong> ${contraseñaValue.web}</p>
                </div>
    `
    nombre.value = '';
    apellido.value = '';
    correo.value = '';
    contraseña.value = '';
    
    })


    