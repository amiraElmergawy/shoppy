function validateInputs() {
    console.log("hello");
}

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const validateEmptyInputs = element => {
    const elmentValue = element.value.trim();

    if (elmentValue === '') {
        setError(element, 'This field is required');
    } else {
        setSuccess(element);
    }
};

const validateEmailInput = emailElement => {

    if (emailElement.value === '') {
        setError(emailElement, 'Email is required');
    } else if (!isValidEmail(emailElement.value)) {
        setError(emailElement, 'Provide a valid email address');
    } else {
        setSuccess(emailElement);
    }
}

const validatePasswordInput = passwordElment => {

    if (passwordElment.value === '') {
        setError(passwordElment, 'Password is required');
    } else if (passwordElment.value.length < 8) {
        setError(passwordElment, 'Password must be at least 8 character.')
    } else {
        setSuccess(passwordElment);
    }
}

const checkPasswordInputsSimilarity = (passwordElement, confirmPasswordElement) => {

    if (confirmPasswordElement.value === '') {
        setError(confirmPasswordElement, 'Please confirm your password');
    } else if (confirmPasswordElement.value !== passwordElement.value) {
        setError(confirmPasswordElement, "Passwords doesn't match");
    } else {
        setSuccess(confirmPasswordElement);
    }

}