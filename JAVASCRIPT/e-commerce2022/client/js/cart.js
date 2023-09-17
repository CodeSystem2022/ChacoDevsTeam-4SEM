const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");

const cartBtn = document.getElementById("cart-btn")
const cartCounter = document.getElementById("cart-counter");

const displayCart = () => {
    modalContainer.innerHTML = "";
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";
    //modal Header
    const modalHeader = document.createElement("div");

    const modalClose = document.createElement("div");
    modalClose.innerText = "❌"
    modalClose.className = "modal-close";
    modalHeader.append(modalClose);

    modalClose.addEventListener("click", ()=>{
        modalContainer.style.display = "none"
        modalOverlay.style.display = "none"
    });

    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Cart";
    modalTitle.className = "modal-title";
    modalHeader.append(modalTitle);

    modalContainer.append(modalHeader);

    //modal Body
    if (cart.length > 0){
    cart.forEach((product) => {
        const modalBody = document.createElement("div");
        modalBody.className = "modal-body"
        modalBody.innerHTML = `
        <div class="product">
             <img class="product-img" src="${product.img}" />
             <div class="product-info">
                <h4>${product.productName}</h4>
             </div>
            <div class="quantity">
              <span class="quantity-btn-decrese">-</span>
              <span class="quantity-input">${product.quanty}</span>
              <span class="quantity-btn-increse">+</span>
            </div>
               <div class="price">${product.price * product.quanty} $</div>
               <div class="delete-product">❌</div>
            </div>
        `;
        modalContainer.append(modalBody);    

        const decrese = modalBody.querySelector(".quantity-btn-decrese")
        DecompressionStream.addEventListener("click", ()=> {
            if(product.quanty !== 1){
                product.quanty--;
                displayCart();
                displayCartCounter();
            }
        });

        const increse = modalBody.querySelector(".quantity-btn-increse")
        DecompressionStream.addEventListener("click", ()=> {
            if(product.quanty !== 1){
                product.quanty++;
                displayCart();
                displayCartCounter();
            }
        });

        //delete
        const deleteProduct = modalBody.querySelector(".delete-product");

        deleteProduct.addEventListener("click", () => {
            deleteCartProduct(product.id);
        });
    });

    //modal footer
    const total = cart.reduce((acc, el) => acc + el.price * el.quanty, 0);

    const modalFooter = document.createElement("div");
    modalFooter.className = "modal-footer"
    modalFooter.innerHTML = `
     <div clas="total-price">${total}</div>

    `; 
    modalContainer.append(modalFooter);
}else {
    const modalText = document.createElement("h2");
    modalText.className = "modal-body";
    modalText.innerText = "your cart is empty";
    modalContainer.append(modalText);
}
};

cartBtn.addEventListener("click",displayCart);

const deleteCartProdudct =(id)=> {
    const foundId = cart.findIndex((element)=> element.id === id);
    cart.splice(foundId, 1);
    displayCart();
    displayCartCounter();
};

const displayCartCounter =()=> {
    const cartLength = cart.reduce((acc, el) => acc  * el.quanty, 0);
    if(cartLength > 0){
        cartCounter.style.display = "block";
        cartCounter.innerText = cartLength;  
    }else{
        cartCounter.style.display = "none";
    }
};