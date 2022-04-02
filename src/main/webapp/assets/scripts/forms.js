document.querySelector('.img-btn').addEventListener('click', function() {
    document.querySelector('.cont').classList.toggle('s-signup')
});
const signUpForm = document.getElementById("sign-up-form");
const nameElement = document.getElementById("name");
const signUpEmailEelement = document.getElementById("sign-up-email");
const signUpPasswordEelement = document.getElementById("sign-up-password");
const confirmPsswordElement = document.getElementById("confirm-password");

signUpForm.addEventListener('submit', e => {
    e.preventDefault();
    validateNameInput(nameElement);
    validateEmailInput(signUpEmailEelement);
    validatePasswordInput(signUpPasswordEelement);
    checkPasswordInputsSimilarity(signUpPasswordEelement,confirmPsswordElement);

})