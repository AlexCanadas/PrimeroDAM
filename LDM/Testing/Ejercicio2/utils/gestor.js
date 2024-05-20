let formulario = document.getElementById("formulario");
let output = document.getElementById("output");

let respuestas = [];

formulario.addEventListener("submit", function(event) {
    event.preventDefault();

    let nuevaRespuesta = {
        nombre: document.getElementById("inputNombre").value,
        email: document.getElementById("inputEmail").value,
        telefono: document.getElementById("inputTelefono").value,
        web: document.getElementById("inputWeb").value,
        asunto: document.getElementById("inputAsunto").value,
        mensaje: document.getElementById("inputMensaje").value
    };

    console.log(nuevaRespuesta);

    if(nuevaRespuesta.nombre && nuevaRespuesta.email && nuevaRespuesta.telefono && nuevaRespuesta.asunto && nuevaRespuesta.mensaje) {
        console.log(nuevaRespuesta);
        respuestas.push(nuevaRespuesta);

        output.innerHTML= `
                <div class="resultado">
                    <h2>Datos del Formulario</h2>
                    <p><strong>Nombre:</strong> ${nuevaRespuesta.nombre}</p>
                    <p><strong>Email:</strong> ${nuevaRespuesta.email}</p>
                    <p><strong>Teléfono:</strong> ${nuevaRespuesta.telefono}</p>
                    <p><strong>Web:</strong> ${nuevaRespuesta.web}</p>
                    <p><strong>Asunto:</strong> ${nuevaRespuesta.asunto}</p>
                    <p><strong>Mensaje:</strong> ${nuevaRespuesta.mensaje}</p>
                </div>
        `;

        formulario.reset();

        alert("¡Respuesta enviada con éxito!");
    }else {
        alert("Faltan datos por rellenar");
    }
})


