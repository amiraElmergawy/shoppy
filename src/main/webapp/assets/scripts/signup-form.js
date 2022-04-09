document.querySelector('.img-btn').addEventListener('click', function() {
    document.querySelector('.cont').classList.toggle('s-signup')
});
const signUpForm = document.getElementById("sign-up-form");
const nameElement = document.getElementById("name");
const signUpEmailEelement = document.getElementById("sign-up-email");
const signUpPasswordEelement = document.getElementById("sign-up-password");
const confirmPsswordElement = document.getElementById("confirm-password");
const birthDateElement=document.getElementById("date");
const favouriteElement=document.getElementById("interests");
const genderElement=document.getElementById("gender");


signUpForm.addEventListener('submit', e => {
    e.preventDefault();
   const validName=validateNameInput(nameElement);
   const validEmail=validateEmailInput(signUpEmailEelement);
   const validPassword=validatePasswordInput(signUpPasswordEelement);
   const isPasswordSimilar=checkPasswordInputsSimilarity(signUpPasswordEelement,confirmPsswordElement);
   const validBirthDate=validateEmptyInputs(birthDateElement);
   const validFavoriteElement=validateEmptyInputs(favouriteElement);
   const validGender=validateEmptyInputs(genderElement);
    if(validName && validEmail && validPassword && isPasswordSimilar && validBirthDate && validFavoriteElement &&validGender){
    $.ajax({
        type: 'post',
        url: '/shoppy/signup',
        data: {
            name:nameElement.value,
            email: emailElement.value,
            password: passwordElement.value,
            birthDate:birthDateElement.value,
            favorite:favouriteElement.value,
            gender:genderElement.value
        },
        contentType : 'application/x-www-form-urlencoded',
        success: function (data) {
            if(data == "Error"){
                var errorDiv = document.getElementById("invaled");
                errorDiv.innerText = data;
                errorDiv.classList.remove("d-none");
            } else {
                console.log(data);
                window.location.replace(data);
            }

        }
    });
    }
    console.log(nameElement.value +"kkkk"+
        +"kkkk"+emailElement.value
        +"kkkk"+passwordElement.value
        +"kkkk"+birthDateElement.value
        +"kkkk"+favouriteElement.value
        +"kkkk"+genderElement.value)
})