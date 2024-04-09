let resultados = document.querySelector("#resultados"); 
let dropdownCategory = document.querySelector("#dropdownCategory"); 
let dropdownMarca = document.querySelector("#dropdownMarca"); 

fetch('https://dummyjson.com/products')
    .then((result) => { // Realizar la petición al servidor y obtener el resultado
        return result.json(); // Pasamos el resultado a JSON
    })
    .then((data) => { // Procesamos los datos JSON que hemos encontrado
        if (data.products.length > 0) {
            data.products.forEach((item) => {
                // Estructura de cada tarjeta
                resultados.innerHTML += `
                    <div class="col">
                        <div class="card" style="width: 18rem;">
                            <img src="${item.thumbnail}" class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title">${item.title}</h5>
                                <p class="card-text">${item.description}</p>
                                <p class="card-text">Precio: ${item.price}€</p>
                                <p class="card-text">Categoría: ${item.category}</p>
                                <a href="#" class="btn btn-primary">Añadir al carrito</a>
                            </div>
                        </div>
                    </div>
                `;
            });
        } else {
            // En caso de no encontrar productos
            resultados.innerHTML = '<p>No se encontraron productos.</p>';
        }
    })
    .catch((error) => {
        // En caso de que haya algun error
        resultados.innerHTML = '<p>Ocurrió un error al obtener los productos.</p>';
    });

function dropdownCategory(data) {
    data.products.category.forEach((item) => {
        let opcion = document.createElement("li");
        opcion.innerHTML += `<li><a class="dropdown-item" href="#">${item.category.value}</a></li>category.value;`
    });
}

function dropdownMarca() {
dropdownMarca
}

