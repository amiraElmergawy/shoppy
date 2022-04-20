function increaseProduct(productId){
    console.log(productId)
    $.ajax({
        url:'shopping-cart',
        type: 'post',
        // contentType: 'application/json',
        data: {
            "productId":productId,
            "quantityAction":"increase"
        },
        // dataType: 'json',
        success: function(data) {
            console.log(data);
            let div = document.getElementById("error");
            if (data!=""){
                div.disabled = true;
                setTimeout(
                    ()=>{
                        div.classList.remove("d-none");
                        div.innerText = data;
                        },
                    500
                );
                div.classList.add("d-none");
            } else {
                div.disabled = false;
                let quantityDiv = document.getElementById(productId+"quantity");
                // console.log(quantityDiv);
                let productPrice = document.getElementById(productId+"price");
                let productTotal = document.getElementById(productId+"productTotal");
                //update quantity
                quantityDiv.innerText = (+quantityDiv.textContent) +1;
                //update total product price
                productTotal.innerText = (+productPrice.textContent)*(+quantityDiv.textContent);
                document.getElementById("productsTotal").innerText = (+document.getElementById("productsTotal").textContent) + (+productPrice.textContent);
            }
        }
    });
    // $.post("shopping-cart", {"productId": productId, "quantityAction":"increase"});

}

function decreaseProduct(productId){
    console.log(productId)
    $.ajax({
        url:'shopping-cart',
        type: 'post',
        // contentType: 'application/json',
        data: {
            "productId":productId,
            "quantityAction":"decrease"
        },
        // dataType: 'json',
        success: function(data) {
            console.log(data)
            let quantityDiv = document.getElementById(productId+"quantity");
            let productPrice = document.getElementById(productId+"price");
            let productTotal = document.getElementById(productId+"productTotal");
            if ((+quantityDiv.textContent) -1 > 0) {
                //update quantity
                quantityDiv.innerText = (+quantityDiv.textContent) - 1;//===> 0 -> delete
                //update total product price
                productTotal.innerText = (+productPrice.textContent) * (+quantityDiv.textContent);
                document.getElementById("productsTotal").innerText = (+document.getElementById("productsTotal").textContent) - (+productPrice.textContent);
            } else deleteProduct(productId);
        }
    });

    // $.post("shopping-cart", {"productId": productId, "quantityAction":"decrease"});

}

function deleteProduct(productId){
    console.log(productId);

    $.ajax({
        url:'shopping-cart',
        type: 'post',
        data: {
            "productId":productId
        },
        success: function(data) {
            console.log(data)
            let productsContainer = document.getElementById("productsContainer");
            let productTotal = document.getElementById(productId+"productTotal").textContent;
            console.log("product total "+productTotal);
            document.getElementById("productsTotal").innerText = (+document.getElementById("productsTotal").textContent) - (+productTotal);
            document.getElementById("productsNo").innerText = +document.getElementById("productsNo").textContent -1
            productsContainer.removeChild(document.getElementById(productId));

        }
    });
}

function saveOrder(){
    $.ajax({
        url:'checkout',
        type: 'post',
        success: function(data) {
            console.log(data);
            let div = document.getElementById("error");
            if (data!=""){
                div.disabled = true;
                setTimeout(
                    ()=>{
                        div.classList.remove("d-none");
                        div.innerText = data;
                    },
                    500
                );
                div.classList.add("d-none");
            } else {
                document.getElementById("creditLimit").innerText = (+document.getElementById("creditLimit").textContent) - (+document.getElementById("productsTotal").textContent);
                document.getElementById("cartContainer").removeChild(document.getElementById("productsContainer"));
                document.getElementById("cart-summary").classList.add("d-none");
                document.getElementById("cart-modal").classList.add("d-none");
            }
        }
    });
    // $.post("checkout");
}