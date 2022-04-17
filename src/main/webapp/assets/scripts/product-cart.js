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
            div = document.getElementById("error");
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
        }
    });

    // $.post("shopping-cart", {"productId": productId, "quantityAction":"decrease"});

}

function deleteProduct(productId){
    console.log(productId);

    $.ajax({
        url:'shopping-cart',
        type: 'post',
        // contentType: 'application/json',
        data: {
            "productId":productId
        },
        // dataType: 'json',
        success: function(data) {
            console.log(data)
        }
    });
}