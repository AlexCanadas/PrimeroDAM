let resultados = document.getElementById("resultados"); 
let dropdownCategory = document.querySelector("#dropdownCategory"); 
let dropdownMarca = document.querySelector("#dropdownMarca");
let removeFilterbutton = document.getElementById("remove-filters");
let range = document.querySelector('#range');
let priceSelectedInput = document.querySelector('#priceSelected');
let carrito = document.querySelector('#carrito');
let precioFinal = document.querySelector('#finalPrice');

var cart = {
    finalPrice: 0,
    items: []
};

range.addEventListener('input', function() {
    console.log(this.value);
    priceSelectedInput.innerHTML = this.value.toString();
    searchFilter("price", this.value);
  }, false);

removeFilterbutton.addEventListener('click', () => {
    removeFilters();
});

let brands     = [];
let categories = [];
let products   = []; 
// Variables para los filtros seleccionados. Se rellena cada vez que haces click en un filtro
let selectedCategory = "";
let selectedBrand = "";
let priceSelected = 0;

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
            <li><a class="dropdown-item" href="#" onclick="searchFilter('brand','${item}')">${item}</a></li>
        `;
    });

}

function addCategories() {
    categories = products.map(product => product.category); // Extraer todas las Categorías de los products
    categories = categories.reduce(function(a,b){ if(a.indexOf(b)<0)a.push(b);return a;}, []); // Eliminar items duplicados
    categories.forEach((item) => {
        // Estructura de cada item del dropdown
        dropdownCategory.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchFilter('category','${item}')">${item}</a></li>
        `;
    });
}

function searchFilter(filterType, value) { 
    // Aquí se asigna el filtro a cada variable de su tipo
    if(filterType ==='brand') {
       selectedBrand = value;
    }
    if(filterType ==='category') {
        selectedCategory = value;
     }
    if(filterType ==='price') {
        priceSelected = value;
    }

    let filteredProducts = products.filter(item => { // Filtramos por categorias y marcas con condicionales
        
        if (selectedCategory && selectedBrand) {
            console.log(selectedCategory, selectedBrand);
            return item.category === selectedCategory && item.brand === selectedBrand;
        } else if (selectedCategory) {
            console.log(selectedCategory);
        return item.category === selectedCategory;
        } else if (selectedBrand) {
            console.log(selectedBrand);
            return item.brand === selectedBrand;
        } 
    });

    // Si no ha tocado el filtro de marca ni de categoría filteresProducts.length = 0
    if (priceSelected && filteredProducts.length === 0) {
        filteredProducts = products.filter(item => { 
        return parseFloat(priceSelected) <= parseFloat(item.price); // Solo devuelve si el precio del item es menor o igual al seleccionado
        });
    }
    else {
        filteredProducts = filteredProducts.filter(item => { 
            // Si se ha seleccionado marca y/o categoría, añadimos el precio
            return parseFloat(priceSelected) <= parseFloat(item.price); // Solo devuelve si el precio del item es menor o igual al seleccionado
            });
    }
    resultados.innerHTML = '';

    if (filteredProducts.length > 0) { // Comprobamos si hay filtros
        filteredProducts.forEach(item => { // Rellenamos resultados
            fillProduct(item, resultados);
        });
    }else {
        fillEmpty(); 
    }
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

function fillEmpty() {
    resultados.innerHTML = `
        <div class="col">
            <p>No se han encontrado resultados</p>
        </div>
    `;
}

function removeFilters() {
    selectedCategory = "";
    selectedBrand = "";
    resultados.innerHTML = '';
    priceSelected = 0;
    priceSelectedInput.innerHTML = "0";
    range.value = 0;

    products.forEach((item) => {
        fillProduct(item, resultados);
    });
    

}

function addProductToCart(productId) {

    console.log('productId', productId);

    let item = null;
    products.forEach(product => {
        if(product.id.toString() === productId.toString()) {
            item = product;
        }
    });

    // Convierte la cadena JSON nuevamente en un objeto JavaScript
    cart.finalPrice += item.price;
    cart.items.push(item);

    console.log('cart', cart);
    
    // Repintar listado de objetos en el cart
    carrito.innerHTML = "";

    cart.items.forEach(item => {
        carrito.innerHTML += `
            <div class="row mb-3 align-items-center">
                <div class="col-md-3">
                    <img src="${item.thumbnail}" style="width: 100%; height: auto;" class="rounded" alt="${item.title}">
                </div>
                <div class="col-md-9">
                    <h5>${item.title}</h5>
                    <p class = id "qtyCategory">Cantidad: ${item.quantity} </p>
                    <p>Precio: ${item.price}€</p>
                </div>
            </div>
        `;
    });

}

