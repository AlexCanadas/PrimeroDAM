let inputNombre = document.getElementById("inputNombre");
let inputEmail = document.getElementById("inputEmail");
let inputTelefono = document.getElementById("inputTelefono");
let inputWeb = document.getElementById("inputWeb");
let inputAsunto = document.getElementById("inputAsunto");
let inputMensaje = document.getElementById("inputMensaje");
let botonEnviar = document.getElementById("enviar");
let output = document.getElementById("output");
let formulario = document.getElementById("formulario");

let respuestas = [];

formulario.addEventListener("submit", function(event) {
    event.preventDefault(); // Previene el envío del formulario y la recarga de la página
    
    
// Obtener los valores de los campos del formulario
let nombre = inputNombre.value;
let email = inputEmail.value;
let telefono = inputTelefono.value;
let web = inputWeb.value;
let asunto = inputAsunto.value;
let mensaje = inputMensaje.value;

console.log(nombre);

if(nombre&&email&&telefono&&asunto&&mensaje) {
  
let nuevaRespuesta = {
    nombre: nombre,
    email: email,
    telefono: telefono,
    web: web,
    asunto: asunto,
    mensaje: mensaje,
};

console.log(nuevaRespuesta);

output.innerHTML = `
            <h3>Datos del Formulario</h3>
            <p><strong>Nombre:</strong> ${nuevaRespuesta.nombre}</p>
            <p><strong>Email:</strong> ${nuevaRespuesta.email}</p>
            <p><strong>Teléfono:</strong> ${nuevaRespuesta.telefono}</p>
            <p><strong>Web:</strong> ${nuevaRespuesta.web}</p>
            <p><strong>Asunto:</strong> ${nuevaRespuesta.asunto}</p>
            <p><strong>Mensaje:</strong> ${nuevaRespuesta.mensaje}</p>
        `;

// Limpiar los campos del formulario después del envío
formulario.reset();

// Opcional: mostrar un mensaje de éxito al usuario
alert("¡Respuesta enviada con éxito!");
} else {
    // Mostrar un mensaje de error si algún campo requerido está vacío
    alert("Por favor completa todos los campos requeridos.");
}
});






