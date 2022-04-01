const form = document.getElementById("edit-form");
const nameElement = document.getElementById("name");
// const genderElement = document.getElementById("gender");
// const interstsElement=document.getElementById("interestes");
// const jopElement = document.getElementById("jop");
const editButton= document.getElementById("edit");
const submitButton = document.getElementById("submit");
form.addEventListener('submit', e => {
    e.preventDefault();
    validateNameInput(nameElement);
    // validateGenderInput(genderElement);
    // validateJopInput(jopElement);
    // validateIntersts(interstsElement);


})
editButton.addEventListener('click',e=>{
    console.log(document.getElementById("name"));
    nameElement.removeAttribute("disabled");
    submitButton.classList.remove('non_visible');

 })












































