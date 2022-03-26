const signInForm = document.getElementById("sign-in-form");
const emailElement = document.getElementById("email");
const passwordElement = document.getElementById("password");

signInForm.addEventListener('submit', e => {
    e.preventDefault();
    validateEmailInput(emailElement);
    validatePasswordInput(passwordElement);
    console.log(emailElement.value);
    // $.post("signin",
    //     {
    //         email: emailElement,
    //         password: passwordElement
    //     },
    //     function(data, status){
    //         console.table("Data: " + data + "\nStatus: " + status);
    //     });
    //

    let post = JSON.stringify(
        {
                "email": emailElement.value,
                "password": passwordElement.value,
                "test":"test"
        }
    )
    const url = "/shoppy/signin"

    let xhr = new XMLHttpRequest()

    xhr.open('POST', url, true)

    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')

    xhr.send("email="+ emailElement.value+"&password="+passwordElement.value);



    xhr.onload = function () {

        if(xhr.status === 201) {

            console.log("Post successfully created!")

        }

    }

})
