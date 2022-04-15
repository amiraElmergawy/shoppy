
function addProduct(productId){
    console.log(productId)
    // $.ajax({
    //     url:'shopping-cart',
    //     type: 'post',
    //     contentType: 'application/json',
    //     data: JSON.stringify(productId),
    //     dataType: 'json',
    //     success: function(data) {
    //         console.log(data)
    //     }
    // });

    $.post("shopping-cart", {"productId": productId});

}