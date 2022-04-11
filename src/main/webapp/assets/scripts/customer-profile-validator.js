const form = document.getElementById("edit-form");
const nameElement = document.getElementById("name");
const genderElement = document.getElementById("gender");
const interestsElement=document.getElementById("interests");
const  dateElement = document.getElementById("date")
const jopElement = document.getElementById("jop");
const cityElement = document.getElementById("city");
const streetElement = document.getElementById("street");
const floorElement = document.getElementById("floor-number");
const buildingElement = document.getElementById("building-number");
const editButton= document.getElementById("edit");
const submitButton = document.getElementById("submit");
form.addEventListener('submit', e => {
    e.preventDefault();
    validateNameInput(nameElement);
    validateEmptyInputs(jopElement);
    validateEmptyInputs(cityElement);
    validateEmptyInputs(streetElement);
    validateEmptyInputs(buildingElement);
    validateEmptyInputs(dateElement);
    validateEmptyInputs(interestsElement);
    validateGenderInput(genderElement);
})
editButton.addEventListener('click',e=>{
    nameElement.removeAttribute("disabled");
    jopElement.removeAttribute("disabled");
    dateElement.removeAttribute("disabled");
    genderElement.removeAttribute("disabled");
    interestsElement.removeAttribute("disabled");
    interestsElement.removeAttribute("disabled");
    cityElement.removeAttribute("disabled");
    streetElement.removeAttribute('disabled');
    buildingElement.removeAttribute('disabled');
    floorElement.removeAttribute('disabled');
    submitButton.classList.remove('non_visible');

 })












































