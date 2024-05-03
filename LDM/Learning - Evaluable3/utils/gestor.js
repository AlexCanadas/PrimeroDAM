let resultados = document.getElementById("resultados");
let dropdownCategory = document.getElementById("dropdownCategory");
let dropdownMarca = document.getElementById("dropdownMarca");
let range = document.querySelector('#range');
let priceSelected = documen.getElementById("priceSelected");
let filtersSelected = document.getElementById("filtersSelected");
let priceHtml = document.getElementById("priceHtml");

let cart = {
    price : 0,
    items : []
};

let products = [];
let categories = [];
let brands = [];

let selectedPrice = 0;
let selectedCategory = "";
let selectedBrand = "";

range.addEventListener("input", function() {
priceSelected.innerHTML = this.value.toString();
searchFilter("price", this.value);
});



fetch('https://dummyjson.com/products')
    .then((pruebaResult) => {
        return pruebaResult.json();
    })
    .then((pruebaData) => {
        if(pruebaData.products.length > 0) {
            products = pruebaData.products

            rellenarCategorias();
            rellenarMarcas();

            products.forEach(item => {
                resultados.innerHTML += `
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
            });
        }else {
            resultados.innerHTML = '<p>No se encontraron productos.</p>';
        }
    })
    .catch((error) => {
        resultados.innerHTML = '<p>Tuvimos un error para encontrar los productos</p>';
    });
    


    function rellenarCategorias () {
        categories = new Set(products.map(product => product.category));

        categories.forEach((item) => {
            dropdownCategory.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchFilter('category','${item}')">${item}</a></li>
        `;
        })
    }

    function rellenarMarcas () {
        brands = new Set(products.map(product => product.brand));

        brands.forEach((item) => {
            dropdownMarca.innerHTML += `
            <li><a class="dropdown-item" href="#" onclick="searchFilter('brand','${item}')">${item}</a></li>
        `;
        })
    }

    function searchFilter (filterType, value) { // Seguir con los filtros
        if(filterType === price) {
            priceSelected = value;
        }
        if(filterType === category) {
            selectedCategory = value;
        }
        if(filterType === brand) {
            selectedBrand = value;
        }

        let filteredProducts = products.filter(item => {
            if(selectedBrand && selectedCategory) {
                filtersSelected.innerHTML = selectedBrand + " " + selectedCategory
                return item.category === selectedCategory && item.brand === selectedBrand;
            }else if (selectedCategory) {
            filtersSelected.textContent= selectedCategory; 
            return item.category === selectedCategory;
            } else if (selectedBrand) {
            filtersSelected.textContent= selectedBrand; 
            return item.brand === selectedBrand;
        } 
        })

    }