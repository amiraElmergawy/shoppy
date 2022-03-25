const nameElement = document.getElementById("name");
const genderElement = document.getElementById("gender");
const iterstsElement=document.getElementById("intersts");
signInForm.addEventListener('submit', e => {
    e.preventDefault();
    validateEmailInput(emailElement);
    validatePasswordInput(passwordElement);
})
signUpForm.addEventListener('submit', e => {
    e.preventDefault();
    validateNameInput(nameElement);
    validateEmailInput(signUpEmailEelement);
    validatePasswordInput(signUpPasswordEelement);

})