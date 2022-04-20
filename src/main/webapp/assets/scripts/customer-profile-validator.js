const form = document.getElementById("edit-form");
const nameElement = document.getElementById("name");
const creditElement = document.getElementById("credit");
const interestsElement=document.getElementById("interests");
const  dateElement = document.getElementById("date");
const jopElement = document.getElementById("job");
const cityElement = document.getElementById("city");
const streetElement = document.getElementById("street");
const floorElement = document.getElementById("floor-number");
const buildingElement = document.getElementById("building-number");
const emailEelement=document.getElementById("emailDiv");
const interestsDisplayElement=document.getElementById("interestsDisplay");
const genderElement=document.getElementById("gender");
const genderDisplayElement=document.getElementById("genderDisplay");



const editButton= document.getElementById("edit");
const submitButton = document.getElementById("save");

editButton.addEventListener('click',e=>{
    nameElement.removeAttribute("disabled");
    dateElement.removeAttribute("disabled");
    creditElement.removeAttribute("disabled");
    cityElement.removeAttribute("disabled");
    streetElement.removeAttribute('disabled');
    buildingElement.removeAttribute('disabled');
    floorElement.removeAttribute('disabled');
    submitButton.classList.remove('non_visible');
    interestsElement.classList.remove('non_visible');
    genderElement.classList.remove('non_visible');
    interestsDisplayElement.classList.add('non_visible');
    genderDisplayElement.classList.add('non_visible');
    emailEelement.classList.add('non_visible');
    jopElement.removeAttribute("disabled");

})

form.addEventListener('submit', e => {
    console.log("%%%%%%%%%form_______");
    e.preventDefault();
    const validName=validateNameInput(nameElement);
    const validBirthDate=validateEmptyInputs(dateElement);
    const validStreet=validateEmptyInputs(streetElement);
    const validBuildingNumber=validateEmptyInputs(buildingElement);
    const validFloorNumber=validateEmptyInputs(floorElement);
    const validJob=validateNameInput(jopElement);
    const validCity=validateNameInput(cityElement);
    const validCredit=validateEmptyInputs(creditElement);

    let customerData ="";

    if(validName && validBirthDate && validFloorNumber && validJob && validBuildingNumber && validStreet && validCity && validCredit) {


        console.log("valid");
        for (var pair of new FormData(form).entries()) {
            console.log(pair[0] + ': ' + pair[1]);
        }
        form.submit();
    }
})












































