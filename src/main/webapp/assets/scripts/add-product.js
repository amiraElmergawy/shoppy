const form = document.getElementById('form');
const productName = document.getElementById('productName')
const category = document.getElementById('category')
const price = document.getElementById('price');
const stock = document.getElementById('stock');
const images = document.getElementById("images");
const desc = document.getElementById('desc');

images.onchange = function (event) {
    var fileList = images.files;
    if (fileList.length != 0) {//test
        PreviewImage(fileList);
    }
}

function PreviewImage(files) {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(files[0]);

    oFReader.onload = function (oFREvent) {
        var img = document.createElement("img");
        img.src = oFREvent.target.result;
        img.width = 100;
        img.height = 100;
        img.classList.add("m-1")
        document.getElementById("imagesArea").appendChild(img);
    };
};

form.addEventListener('submit', e => {
    e.preventDefault();

    validateEmptyInputs(productName)
    checkCategory()
    checkImages()
    validateEmptyInputs(price)
    validateEmptyInputs(stock)
    validateEmptyInputs(desc)

    // if( validateEmptyInputs(productName) && checkCategory() && validateEmptyInputs(price) && validateEmptyInputs(stock) && validateEmptyInputs(desc)){
    //     console.log("you can send the request now ^_^");
    //     //send the post request
    // }
});

function checkCategory() {
    console.log(category.options[category.selectedIndex].value)
    if (category.options[category.selectedIndex].value == "") {
        category.classList.add("select-error");
        var errorDiv = category.parentNode.parentNode.parentNode.children[2];
        errorDiv.classList.add("custom-error");
        errorDiv.innerHTML = "This field is required";
        return false;
    } else { //there is category selected
        var errorDiv = category.parentNode.parentNode.parentNode.children[2];
        if (errorDiv.classList.contains("custom-error"))
            errorDiv.classList.remove("custom-error");
        if (category.classList.contains("select-error"))
            category.classList.remove("select-error");
        errorDiv.innerHTML = "";
        return true;
    }

}


function checkImages() {
    var imagesArea = document.getElementById("imagesArea");
    var errorDiv = imagesArea.children[1];
    var fileInput = imagesArea.children[0];
    if (images.files.length == 0) { //there is no selected img
        fileInput.classList.add("select-error");
        errorDiv.classList.add("custom-error");
        errorDiv.innerHTML = "This field is required";
        return false;
    } else {
        if (errorDiv.classList.contains("custom-error"))
            errorDiv.classList.remove("custom-error");
        if (fileInput.classList.contains("select-error"))
            fileInput.classList.remove("select-error");
        errorDiv.innerHTML = "";
        return true;
    }
}

//upload image with ajax
// async function uploadFile() {
//     let formData = new FormData();
//     formData.append("file", ajaxfile.files[0]); //can be array
//     await fetch('fileuploadservlet', {
//       method: "POST",
//       body: formData
//     });
//     alert('The file upload with Ajax and Java was a success!');
//   }