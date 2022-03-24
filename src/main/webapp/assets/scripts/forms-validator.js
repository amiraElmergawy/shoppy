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
    } else if (passwordElment.value.length < 8) {
        setError(passwordElment, 'Password must be at least 8 character.')
        return false;
    } else {
        setSuccess(passwordElment);
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