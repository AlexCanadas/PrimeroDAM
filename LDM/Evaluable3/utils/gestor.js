let resultados = document.getElementById("resultados"); 
let dropdownCategory = document.querySelector("#dropdownCategory"); 
let dropdownMarca = document.querySelector("#dropdownMarca");
let removeFilterbutton = document.getElementById("remove-filters");
let range = document.querySelector('#range');
let priceSelectedInput = document.querySelector('#priceSelected');
let carrito = document.querySelector('#carrito');
let precioFinal = document.querySelector('#precioFinal');
let filtersSelected = document.querySelector('#filtrosSeleccionados');
let priceHtml = document.querySelector('#priceHtml');
let cartCounter = document.getElementById('cartCounter');
let inputSearch = document.getElementById('inputSearch');

var cart = {
    finalPrice: 0,
    items: []
};

range.addEventListener('input', function() {
    console.log(this.value);
    priceSelectedInput.innerHTML = this.value.toString();
    searchFilter("price", this.value);
  });

//On change de un input y con el e.target.value llamar a globalSearch
// https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event
// Asigna el evento 'change' al campo de entrada
inputSearch.addEventListener('change', function(event) {
    console.log(inputSearch);
    // Obtén el valor actual del campo de entrada cuando cambie
    let inputString = event.target.value;
    console.log(inputString);
    // Llama a la función globalSearch pasando el valor del campo de entrada
    globalSearch(inputString);
  });


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
    brands = brands.reduce(function(a,b){ // Eliminar items duplicados
        if(a.indexOf(b)<0)a.push(b);
        return a;}, []); 
    brands.forEach((item) => {
        // Estructura de cada item del dropdown
        dropdownMarca.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchFilter('brand','${item}')">${item}</a></li>
        `;
    });

}

function addCategories() {
    categories = products.map(product => product.category); // Extraer todas las Categorías de los products
    categories = categories.reduce(function(a,b){  // Eliminar items duplicados
        if(a.indexOf(b)<0)a.push(b);
        return a;}, []); 
    categories.forEach((item) => {
        // Estructura de cada item del dropdown
        dropdownCategory.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchFilter('category','${item}')">${item}</a></li>
        `;
    });
}


//Recibe el input de un onChange de un input
function globalSearch(inputString) {
 
    let filteredProducts = products.filter(item => {
        let searchString = inputString.toLowerCase();
        return item.title.toLowerCase().includes(searchString);
    });

    fillProduct(item, filteredProducts);
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
            filtersSelected.textContent= selectedCategory + ' ' + selectedBrand; // Rellenamos filtersSelected
            return item.category === selectedCategory && item.brand === selectedBrand;
        } else if (selectedCategory) {
            filtersSelected.textContent= selectedCategory; // Rellenamos filtersSelected
        return item.category === selectedCategory;
        } else if (selectedBrand) {
            filtersSelected.textContent= selectedBrand; // Rellenamos filtersSelected
            return item.brand === selectedBrand;
        } 
    });

    // Si no ha tocado el filtro de marca ni de categoría filteredProducts.length = 0
    if (priceSelected && filteredProducts.length === 0) {
        filteredProducts = products.filter(item => { 
        priceHtml.textContent = priceSelected + '€'; // Pintamos el precio en priceHtml (filtros seleccionados)
        return parseFloat(priceSelected) <= parseFloat(item.price); // Solo devuelve si el precio del item es menor o igual al seleccionado
        });
    }
    else {
        filteredProducts = filteredProducts.filter(item => { 
            // Si se ha seleccionado marca y/o categoría, añadimos el precio
            if (priceSelected) {
            priceHtml.textContent = priceSelected + '€'; // Pintamos el precio en priceHtml (filtros seleccionados) 
            }
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

function fillProduct(item, parentDiv) { // Función para rellenar resultados
    parentDiv.innerHTML += `
        <div class="col">
            <div class="card animate__bounceIn" style="width: 16rem;">
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

function fillEmpty() { // En caso de que no se encuentren artículos con X filtros
    resultados.innerHTML = `
        <div class="col">
            <p>No se han encontrado resultados</p>
        </div>
    `;
}

function removeFilters() { // Quitamos filtros
    selectedCategory = "";
    selectedBrand = "";
    resultados.innerHTML = '';
    priceSelected = 0;
    priceSelectedInput.innerHTML = "0";
    range.value = 0;
    filtersSelected.innerHTML='';
    priceHtml.innerHTML='';

    products.forEach((item) => {
        fillProduct(item, resultados);
    });
}

// Funcion para añadir producto al carro
function addProductToCart(productId) { 
    // Comparamos el id que trae el objeto con el array de product
    let item = products.find(product => product.id.toString() === productId.toString());

    if (item) {
        // Sumamos el precio del item al finalPrice del carrito (objeto cart)
        cart.finalPrice += item.price;

        // Vemos si ya existe en el carrito ese id
        let existingItem = cart.items.find(cartItem => cartItem.id === item.id);

        if (existingItem) {
            // Si ya está en el carrito, sumamos la cantidad
            existingItem.quantity++;
        } else {
            // Inicializamos quantity en 1 en caso de que no exista ya en el carrito
            item.quantity = 1; // Creamos la propiedad quantity y la inicializamos en 1
            cart.items.push(item);
        }

        // Actualiza el precio final en el HTML
        if (precioFinal) {
            precioFinal.textContent = cart.finalPrice;
        }
    }

    updateCartView(); // Actualizamos el carrito
    fillCartProductCounter(); 

}

// Funcion para rellenar el contador del símbolo del carrito
function fillCartProductCounter() {
    let counter = 0;

    cart.items.forEach(item => {
        counter += item.quantity;
    })

    cartCounter.innerHTML = counter;

    if(counter > 0) {
        cartCounter.classList.add('filled');
    } else {
        cartCounter.classList.remove('filled');
    }

}

// Funcion para aumentar el item.quantity desde el botón + en el carrito
function addOneMoreProductToCart(productId) {
    let indexToSum = cart.items.findIndex(item => item.id.toString() === productId.toString());

    if (indexToSum !== -1) {
        let productToAdd = cart.items[indexToSum];

        cart.finalPrice += productToAdd.price;
        productToAdd.quantity++;
        
        // Actualizamos el precio final y el html del carrito
        precioFinal.textContent = cart.finalPrice.toString();
        updateCartView();
        fillCartProductCounter();
    } 
}

function removeProductFromCart(productId) {
    let indexToRemove = cart.items.findIndex(item => item.id.toString() === productId.toString());

    if (indexToRemove !== -1) {
        let itemToRemove = cart.items[indexToRemove];

        if (itemToRemove.quantity === 1) {
            // Si item.cantidad es 1, eliminamos el item del carrito
            cart.finalPrice -= itemToRemove.price;
            cart.items.splice(indexToRemove, 1);
        } else if (itemToRemove.quantity > 1) {
            // Si item.cantidad es mayor de 1, eliminamos un item de item.cantidad
            cart.finalPrice -= itemToRemove.price;
            itemToRemove.quantity--;
        }

        // Actualizamos el precio final y el html del carrito
        precioFinal.textContent = cart.finalPrice.toString();
        updateCartView();
        fillCartProductCounter();
    } 
}

function updateCartView() {
    // Vacía el contenido del carrito en el HTML
    carrito.innerHTML = '';

    // Rellena nuevamente el carrito con los productos actualizados en cart.items
    cart.items.forEach(item => {
        carrito.innerHTML += `
            <div class="row mb-3 align-items-center">
                <div class="col-md-3">
                    <img src="${item.thumbnail}" style="width: 100%; height: auto;" class="rounded" alt="${item.title}">
                </div>
                <div class="col-md-9">
                    <h5>${item.title}</h5>
                    <p>Cantidad: <span>${item.quantity}</span> 
                    <button type="button" class="btn btn-outline-secondary" onclick="addOneMoreProductToCart('${item.id}')">
                    <i class="bi bi-plus-circle"></i></button>
                    <button type="button" class="btn btn-outline-secondary" onclick="removeProductFromCart('${item.id}')">
                    <i class="bi bi-dash-circle"></i></button> </p> 
                    <p>Precio: ${item.price}€</p>
                </div>
            </div>
        `;
    });


}
