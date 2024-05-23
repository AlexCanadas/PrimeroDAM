let tweet = document.getElementById("tweetInput");
let output = document.getElementById("output");
let boton = document.getElementById("boton");


boton.addEventListener("click", () => {
let tweet = tweetInput.value;

output.innerHTML += `
<div class="col mb-2">
    <div class="card" style="width: 16rem;">
        <img src="./images/twitter-x.webp" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${tweet}</h5>
        </div>
    </div>
</div>
`
tweetInput.value = '';

})
