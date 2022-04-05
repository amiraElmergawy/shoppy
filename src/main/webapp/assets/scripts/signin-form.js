const signInForm = document.getElementById("sign-in-form");
const emailElement = document.getElementById("email");
const passwordElement = document.getElementById("password");

signInForm.addEventListener('submit', e => {
    e.preventDefault();
    // validateEmailInput(emailElement);
    // validatePasswordInput(passwordElement);
    // console.log(emailElement.value);

    $.ajax({
        type: 'post',
        url: '/shoppy/login',
        data: {
            email: emailElement.value,
            password: passwordElement.value
        },
        contentType : 'application/x-www-form-urlencoded',
        success: function (data) {
            console.log(data);
            if(data == "Invalid email or password"){
                var errorDiv = document.getElementById("invaled");
                errorDiv.innerText = data;
                errorDiv.classList.remove("d-none");
            } else {
                data.redirect;
            }

        }
    });

})
