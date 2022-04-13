const emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
const passwordPattern = /^([A-Za-z]|[0-9]){8,}$/;
const namePattern = /^[A-Za-z]\w{2,29}$/;
const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    // inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    // inputControl.classList.add('success');
    inputControl.classList.remove('error');
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

const checkPasswordInputsSimilarity = (passwordElement, confirmPasswordElement) => {

    if (confirmPasswordElement.value === '') {
        setError(confirmPasswordElement, 'Please confirm your password');
        return false;

    } else if (confirmPasswordElement.value !== passwordElement.value) {
        setError(confirmPasswordElement, "Passwords doesn't match");
        return false;

    } else {
        console.log("match")
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