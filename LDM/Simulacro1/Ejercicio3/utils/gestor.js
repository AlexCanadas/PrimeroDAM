let inputNombre = document.getElementById("inputNombre");
let inputEmail = document.getElementById("inputEmail");
let inputTelefono = document.getElementById("inputTelefono");
let inputWeb = document.getElementById("inputWeb");
let inputAsunto = document.getElementById("inputAsunto");
let inputMensaje = document.getElementById("inputMensaje");
let botonEnviar = document.getElementById("enviar");

let respuestas = [];

botonEnviar.addEventListener("click", function() {
// Obtener los valores de los campos del formulario
let nombre = inputNombre.value;
let email = inputEmail.value;
let telefono = inputTelefono.value;
let asunto = inputAsunto.value;
let mensaje = inputMensaje.value;

if(nombre&&email&&telefono&&asunto&&mensaje) {
let nuevaRespuesta = {
    nombre: nombre,
    email: email,
    telefono: telefono,
    asunto: asunto,
    mensaje: mensaje
};

respuestas.push(nuevaRespuesta);
console.log("Respuesta enviada con éxito:", nuevaRespuesta);

    // Limpiar los campos del formulario después del envío
    inputNombre.value = "";
    inputEmail.value = "";
    inputTelefono.value = "";
    inputAsunto.value = "";
    inputMensaje.value = "";
// Opcional: mostrar un mensaje de éxito al usuario
alert("¡Respuesta enviada con éxito!");
} else {
    // Mostrar un mensaje de error si algún campo requerido está vacío
    alert("Por favor completa todos los campos requeridos.");
}
});






