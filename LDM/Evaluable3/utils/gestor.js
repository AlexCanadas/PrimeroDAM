let resultados = document.getElementById("resultados"); 
let dropdownCategory = document.querySelector("#dropdownCategory"); 
let dropdownMarca = document.querySelector("#dropdownMarca");
let removeFilterbutton = document.getElementById("remove-filters");

removeFilterbutton.addEventListener('click', () => {
    removeFilters();
});

let brands     = [];
let categories = [];
let products   = [];

let selectedFilters = [];

fetch('https://dummyjson.com/products')
    .then((result) => { // Realizar la petición al servidor y obtener el resultado
        return result.json(); // Pasamos el resultado a JSON
    })
    .then((data) => { // Procesamos los datos JSON que hemos encontrado

        if (data.products.length > 0) {

            products = data.products;

            addBrands(); // Rellenamos dropdown de Marcas
            addCategories(); // Rellenamos dropdown de Categorías

            products.forEach((item) => { // Recorremos products y rellenamos con el resultado
                fillProduct(item, resultados);
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


function addBrands() {
    brands = products.map(product => product.brand); // Extraer todas las Marcas de los products
    brands = brands.reduce(function(a,b){ if(a.indexOf(b)<0)a.push(b);return a;}, []); // Eliminar items duplicados

    brands.forEach((item) => {
        // Estructura de cada item del dropdown
        dropdownMarca.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchByBrand('${item}')">${item}</a></li>
        `;
    });

}


let selectedCategory = ''; // Variable para almacenar el item seleccionado del dropdown

function addCategories() {
    categories = products.map(product => product.category); // Extraer todas las Categorías de los products
    categories = categories.reduce(function(a,b){ if(a.indexOf(b)<0)a.push(b);return a;}, []); // Eliminar items duplicados
    categories.forEach((item) => {
        // Estructura de cada item del dropdown
        dropdownCategory.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchByCategory('${item}')">${item}</a></li>
        `;
    });
}

function searchByCategory(category) {

    const arrayProductsfiltered = products.filter(product => product.category === category); // Filtrar products por categoría seleccionada
    console.log(arrayProductsfiltered);

    resultados.innerHTML = '';

    arrayProductsfiltered.forEach((item) => { // Mostrar los productos filtrados en la resultados
        fillProduct(item, resultados);
    });

}

function searchByBrand(brand) {
    
    const arrayProductsfiltered = products.filter(product => product.brand === brand); // Filtrar products por Marca seleccionada

    if(arrayProductsfiltered.length === 0 || !arrayProductsfiltered) {  // Verificamos si se encontraron productos filtrados
        return;
    }

    resultados.innerHTML = '';

    arrayProductsfiltered.forEach((item) => {  // Mostrar los productos filtrados en la resultados
        fillProduct(item, resultados);
    });

}

function searchFilter(filterType, value) {

}


function fillProduct(item, parentDiv) {
    parentDiv.innerHTML += `
        <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="${item.thumbnail}" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">${item.title}</h5>
                    <p class="card-text">${item.description}</p>
                    <p class="card-text">Precio: ${item.price}€</p>
                    <p class="card-text">Categoría: ${item.category}</p>
                    <a href="#" class="btn btn-primary add-to-cart-btn" onclick="addProductToCart('${item.id}')">Añadir al carrito</a>
                </div>
            </div>
        </div>
    `;
}

/**
 * Crear botón que llame a esta función
 */
function removeFilters() {

    resultados.innerHTML = '';

    products.forEach((item) => {
        fillProduct(item, resultados);
    });
    

}

function addProductToCart(productId) {

    console.log('productId', productId);

    const item = products.filter(product => product.id.toString() === productId.toString())[0];

    // Convierte la cadena JSON nuevamente en un objeto JavaScript

    cart.finalPrice += item.price;
    cart.items.push(item);

    console.log('cart', cart);

}

/**
 *  
 * document.cookie 
 * 
 */
var cart = {
    finalPrice: 0,
    items: []
};