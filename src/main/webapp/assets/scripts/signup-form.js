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
const genderElement=document.getElementById("gender").value === "male"?true:false;


signUpForm.addEventListener('submit', e => {
    e.preventDefault();
   const validName=validateNameInput(nameElement);
   const validEmail=validateEmailInput(signUpEmailEelement);
   const validPassword=validatePasswordInput(signUpPasswordEelement);
   const isPasswordSimilar=checkPasswordInputsSimilarity(signUpPasswordEelement,confirmPsswordElement);
   const validBirthDate=validateEmptyInputs(birthDateElement);
   let customerData ="";

   if(validName && validEmail && validPassword && isPasswordSimilar && validBirthDate) {
       console.log(signUpForm.value);
       for (var pair of new FormData(signUpForm).entries()) {
           console.log(pair[0] + ': ' + pair[1]);
       }
       signUpForm.submit();
        // var xmlHttp = new XMLHttpRequest();
        // xmlHttp.open("post", '/shoppy/register', true);
        // customerData = {
        //     username: nameElement.value,
        //     email: signUpEmailEelement.value,
        //     password: signUpPasswordEelement.value,
        //     dateOfBirth: birthDateElement.value,
        //     interests: favouriteElement.value,
        //     isMale: genderElement
        // };
        // console.log(customerData);
        // xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        // xmlHttp.send("customerData=" + JSON.stringify(customerData));

    }
})

