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
   let customerData ="";

   console.log("email: "+signUpEmailEelement.value);
   console.log("password: "+signUpPasswordEelement.value);
    if(validName && validEmail && validPassword && isPasswordSimilar && validBirthDate) {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post", '/shoppy/register', true);
        customerData = {
            name: nameElement.value,
            email: signUpEmailEelement.value,
            password: signUpPasswordEelement.value,
            birthDate: birthDateElement.value,
            favorite: favouriteElement.value,
            gender: genderElement.value
        };
        console.log(customerData);
        xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xmlHttp.send("customerData=" + JSON.stringify(customerData));
        //
        // req.open("POST", url, true);
        // req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        // req.onreadystatechange = handleStateChange;
        // req.send("uName=" + yourvalue);

    }
})

