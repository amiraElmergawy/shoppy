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
    const validName=validateEmptyInputs(nameElement);
    const validBirthDate=validateEmptyInputs(dateElement);
    const validStreet=validateEmptyInputs(streetElement);
    const validBuildingNumber=validateEmptyInputs(buildingElement);
    const validFloorNumber=validateEmptyInputs(floorElement);
    const validJob=validateEmptyInputs(jopElement);
    const validCity=validateEmptyInputs(cityElement);

    let customerData ="";

    if(validName && validBirthDate && validFloorNumber && validJob && validBuildingNumber && validStreet && validCity) {


        // let xmlHttp = new XMLHttpRequest();
        // xmlHttp.open("POST", '/shoppy/profile', true);
        // customerData = {
        //     username: nameElement.value,
        //     email: emailEelement.value,
        //     dob: dateElement.value,
        //     interests: interestsElement.value,
        //     job:jopElement.value,
        //     street:streetElement.value,
        //     floorNumber:floorElement.value,
        //     buildingNumber:buildingElement.value,
        //     city:cityElement.value,
        //     gender:genderElement.value
        // };
        // console.log(customerData);
        // xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        // xmlHttp.send("customerData=" + JSON.stringify(customerData));
        // console.log(customerData);
        // submitButton.submit();
        console.log("valid");
        for (var pair of new FormData(form).entries()) {
            console.log(pair[0] + ': ' + pair[1]);
        }
        form.submit();
    }
})












































