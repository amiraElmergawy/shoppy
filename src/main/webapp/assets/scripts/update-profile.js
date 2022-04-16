// const save = document.getElementsByClassName("saveBtn");
const nameElement = document.getElementById("name");
const emailEelement = document.getElementById("sign-up-email");
const passwordEelement = document.getElementById("sign-up-password");
const passwordElement = document.getElementById("confirm-password");
const birthDateElement=document.getElementById("date");
const favouriteElement=document.getElementById("interests");
const genderElement=document.getElementById("gender").value === "male"?true:false;
const jobElement=document.getElementById("jop");
const  cityElement=document.getElementById("city");
const  streetElement=document.getElementById("street");
const  buildingNumberElement=document.getElementById("building-number");
const  floorNumberElement=document.getElementById("floor-number");



submitButton.addEventListener('submit', e => {
  e.preventDefault();
  const validName=validateNameInput(nameElement);
  const validEmail=validateEmailInput(signUpEmailEelement);
  const validPassword=validatePasswordInput(signUpPasswordEelement);
  const isPasswordSimilar=checkPasswordInputsSimilarity(signUpPasswordEelement,confirmPsswordElement);
  const validBirthDate=validateEmptyInputs(birthDateElement);
  const validStreet=validateEmptyInputs(streetElement);
  const validBuildingNumber=validateEmptyInputs(buildingNumberElement);
  const validFloorNumber=validateEmptyInputs(floorNumberElement);
  const validJob=validateEmptyInputs(jobElement);
  let customerData ="";

  if(validName && validEmail && validPassword && isPasswordSimilar && validBirthDate &&validFloorNumber &&validJob && validBuildingNumber && validStreet) {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("post", '/shoppy/profile', true);
    customerData = {
        username: nameElement.value,
        email: emailEelement.value,
        dateOfBirth: birthDateElement.value,
        interests: favouriteElement.value,
        job:jobElement.value,
        street:streetElement.value,
        floorNumber:floorNumberElement.value,
        buildingNumber:buildingNumberElement.value,
        city:cityElement.value,
    };
    console.log(customerData);
    xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlHttp.send("customerData=" + JSON.stringify(customerData));

  }
})
