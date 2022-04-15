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
// form.addEventListener('submit', e => {
//     e.preventDefault();
//     validateNameInput(nameElement);
//     validateEmptyInputs(jopElement);
//     validateEmptyInputs(cityElement);
//     validateEmptyInputs(streetElement);
//     validateEmptyInputs(buildingElement);
//     validateEmptyInputs(dateElement);
//     validateEmptyInputs(interestsElement);
//     validateGenderInput(genderElement);
// })
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

submitButton.addEventListener('submit', e => {
    e.preventDefault();
    const validName=validateNameInput(nameElement);
    const validEmail=validateEmailInput(emailEelement);
    const validBirthDate=validateEmptyInputs(dateElement);
    const validStreet=validateEmptyInputs(streetElement);
    const validBuildingNumber=validateEmptyInputs(buildingElement);
    const validFloorNumber=validateEmptyInputs(floorElement);
    const validJob=validateEmptyInputs(jopElement);
    const validCity=validateEmptyInputs(cityElement);

    let customerData ="";

    if(validName && validEmail && validBirthDate &&validFloorNumber &&validJob && validBuildingNumber && validStreet && validCity) {

        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("PUT", '/shoppy/profile', true);
        customerData = {
            username: nameElement.value,
            email: emailEelement.value,
            dateOfBirth: dateElement.value,
            interests: interestsElement.value,
            job:jopElement.value,
            street:streetElement.value,
            floorNumber:floorElement.value,
            buildingNumber:buildingElement.value,
            city:cityElement.value,
        };
        console.log(customerData);
        xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xmlHttp.send("customerData=" + JSON.stringify(customerData));
        console.log(customerData);
        submitButton.submit();
    }
})












































