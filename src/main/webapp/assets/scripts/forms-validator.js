const emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
const passwordPattern = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
const namePattern = /^[a-zA-Z ]{2,30}$/;
const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    // inputControl.classList.remove('success')
    console.log(errorDisplay);
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');
     errorDisplay.innerText ='';
    inputControl.classList.remove('error');
    inputControl.classList.add('success');
};

const validateEmptyInputs = element => {
    const elmentValue = element.value.trim();

    if (elmentValue === '') {
        setError(element, 'This field is required');
        return false;
    } else {
        setSuccess(element);
        return true;
    }

};

const validateEmailInput = emailElement => {

    if (emailElement.value === '') {
        setError(emailElement, 'Email is required');
        return false;
    } else if (!isValidEmail(emailElement.value)) {
        setError(emailElement, 'Provide a valid email address');
        return false;
    } else {
        setSuccess(emailElement);
        return true;
    }
}

const validatePasswordInput = passwordElment => {

    if (passwordElment.value === '') {
        setError(passwordElment, 'Password is required');
        return false;
    } else if (passwordElment.value.length < 8 && !isValidPassword(passwordElment.value)) {
        setError(passwordElment, 'Password must be at least 8 character.')
        return false;
    } else {
        setSuccess(passwordElment);
        return true;
    }
}
const validateNameInput = nameElement => {
    if (nameElement.value === '') {
        setError(nameElement, 'This field is required');
        return false;
    } else if (!isValidName(nameElement.value)) {
        setError(nameElement, 'Wrong')
        return false;
    } else {
        setSuccess(nameElement);
        return true;
    }
}
const validateIntersts = interstsElement=>{
    if (interstsElement.value === '') {
        setError(interstsElement, 'This field is required');
        return false;
    }  else {
        setSuccess(interstsElement);
        return true;
    }

}
const validateGenderInput = genderElement =>{
    if (genderElement.value === '') {
        setError(genderElement, 'You should enter your gender');
        return false;
    } else if (!isValidGender(genderElement.value)) {
        setError(genderElement, 'Wrong')
        return false;
    } else {
        setSuccess(genderElement);
        return true;
    }

}
const validateJopInput = jopElement => {
    if (jopElement.value === '') {
        setError(jopElement, 'You should enter your gender');
        return false;
    }
    else {
        setSuccess(jopElement);
        return true;
    }

}
const checkPasswordInputsSimilarity = (passwordElement, confirmPasswordElement) => {

    if (confirmPasswordElement.value === '') {
        setError(confirmPasswordElement, 'Please confirm your password');
        return false;
    } else if (confirmPasswordElement.value !== passwordElement.value) {
        setError(confirmPasswordElement, "Passwords doesn't match");
        return false;
    } else {
        setSuccess(confirmPasswordElement);
        return true;
    }

}
const isValidEmail = emailElementValue => {
    if (emailPattern.test(emailElementValue))
        return true;
    else
        return false;


}
const isValidPassword = passwordElementValue => {
    if (passwordPattern.test(passwordElementValue))
        return true;
    else
        return false;
}
const isValidName = nameElementValue => {
    if (namePattern.test(nameElementValue))
        return true;
    else
        return false;
}
const isValidGender = genderElementValue => {

    if(genderElementValue === "female" || genderElementValue === "male"){
        return true;
    }
    else{
        return false;
    }

}