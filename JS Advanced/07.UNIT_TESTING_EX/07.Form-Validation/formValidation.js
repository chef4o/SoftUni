function validate() {
    const usernameValidation = /^[A-Za-z0-9]{3,20}$/;
    const passwordValidation = /^[\w]{5,10}$/;
    const emailValidation = /^[A-Za-z0-9_\-\.]+@[A-Za-z0-9.]+$/;

    let isValidInput = true;
    let isChecked = false;

    const submitBtn = document.getElementById("submit");
    submitBtn.addEventListener('click', (ev) => {
        ev.preventDefault();
        const usernameField = document.getElementById('username');
        if (!usernameValidation.test(usernameField.value)) {
            isValidInput = false;
            usernameField.style.borderColor = 'red';
        } else {
            usernameField.style.border = 'none';
        }

        const emailField = document.getElementById('email');
        if (!emailValidation.test(emailField.value)) {
            isValidInput = false;
            emailField.style.borderColor = 'red';
        } else {
            emailField.style.border = 'none';
        }

        const passwordField = document.getElementById('password');
        const confirmPasswordField = document.getElementById('confirm-password');

        if (!passwordValidation.test(passwordField.value)
            || passwordField.value != confirmPasswordField.value) {
            isValidInput = false;
            passwordField.style.borderColor = 'red';
            confirmPasswordField.style.borderColor = 'red';
        } else {
            passwordField.style.border = 'none';
            confirmPasswordField.style.border = 'none';
        }

        const validDiv = document.getElementById('valid');
        if (isValidInput) {
            validDiv.style.display = 'block';
        } else {
            validDiv.style.display = 'none';
        }

        if (isChecked) {
            const cNumber = document.getElementById('companyNumber');
            if (Number(cNumber.value) < 1000 || Number(cNumber.value > 9999)) {
                cNumber.style.borderColor = 'red';
            } else {
                cNumber.style.border = 'none';
            }
        }

    });

    document.getElementById('company').addEventListener('change', (e) => {
        const sompanyField = document.getElementById('companyInfo');
        if (e.target.checked) {
            isChecked = true;
            sompanyField.style.display = 'block';
        } else {
            isChecked = false;
            sompanyField.style.display = 'none';
        }
    });
}


// alt solution

function validate() {
    document.querySelector("#submit").type = "button";
    document.querySelector("#company").addEventListener("change", (e) => {
        console.log(e.target);
        if (document.querySelector("#company").checked) {
            document.querySelector("#companyInfo").style.display = "block";
        } else {
            document.querySelector("#companyInfo").style.display = "none";
        }
    });

    document.querySelector("#submit").addEventListener("click", (e) => {
        let validOut = [];
        let userName = document.querySelector("#username");
        let email = document.querySelector("#email");
        let passWord = document.querySelector("#password");
        let confirmPass = document.querySelector("#confirm-password");
        let checkBox = document.querySelector("#company");
        let userTest = /^[A-Za-z0-9]{3,20}$/;
        let emailTest = /^[^@.]+@[^@]*\.[^@]*$/;
        let passTest = /^[\w]{5,15}$/;

        //console.log(checkBox.checked);

        if (userTest.exec(userName.value) === null) {
            userName.style.borderColor = "red";
            validOut.push(false);
        } else {
            userName.style.borderColor = "";
            validOut.push(true);
        }

        if (emailTest.exec(email.value) === null) {
            email.style.borderColor = "red";
            validOut.push(false);
        } else {
            email.style.borderColor = "";
            validOut.push(true);
        }

        if (
            passWord.value === confirmPass.value &&
            passTest.exec(confirmPass.value) != null &&
            passTest.exec(passWord.value) != null
        ) {
            confirmPass.style.borderColor = "";
            passWord.style.borderColor = "";
            validOut.push(true);
        } else {
            confirmPass.style.borderColor = "red";
            passWord.style.borderColor = "red";
            validOut.push(false);
        }

        if (checkBox.checked) {
            let company = document.querySelector("#companyNumber");
            if (company.value < 1000 || company.value > 9999) {
                company.style.borderColor = "red";
                validOut.push(false);
            } else {
                company.style.borderColor = "";
                validOut.push(true);
            }
        }

        if (!validOut.includes(false)) {
            document.querySelector("#valid").style.display = "block";
        } else {
            document.querySelector("#valid").style.display = "none";
        }
    });
}
