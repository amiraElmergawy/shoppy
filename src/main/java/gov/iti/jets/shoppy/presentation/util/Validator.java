package gov.iti.jets.shoppy.presentation.util;

import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.customer.CustomerPostRequestDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Validator validator = new Validator();
    private Matcher matcher ;
    private Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
//    private Pattern passwordPattern = Pattern.compile("^([A-Za-z]|[0-9]){8,}$");
    private Pattern passwordPattern = Pattern.compile("^[1-9 a-z A-Z]{8,}$");
    private Pattern namePattern = Pattern.compile("^[A-Za-z]{2,29}$");
    private Pattern datePattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");

    //Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters

    private Validator(){}

    public static Validator getInstance(){
        return validator;
    }

    public boolean validateLoginFields(String email, String password){
        return validateEmail(email) && validatePassword(password);
    }

    public boolean validateSignupFields(CustomerPostRequestDto customerDto){
        return validateUserName(customerDto.getUsername().trim()) && validateEmail(customerDto.getEmail().trim()) && validatePassword(customerDto.getPassword().trim())  && validateDate(customerDto.getDateOfBirth().trim()) && validateEmptyInputs(customerDto.getInterests().trim());
    }
    private boolean validateEmail(String email){
        this.matcher = this.emailPattern.matcher(email);
        if (this.matcher.matches()){
            return true;
        }
        System.out.println("email not valid");
        return false;
    }

    private boolean validatePassword(String password){
        this.matcher = this.passwordPattern.matcher(password);
        if (this.matcher.matches()){
            return true;
        }
        System.out.println("pass not valid");
        return false;
    }
    private boolean validateUserName(String userName){
        if(userName != null){
            this.matcher = this.namePattern.matcher(userName);
            if (this.matcher.matches()){
                return true;
            }else{
                System.out.println("name not valid");
                return false;
            }
        }
        System.out.println("name not valid");
        return false;

    }
    private boolean checkPasswordSimilarity(String password, String confirmPassword){
        if(password !=null && confirmPassword !=null){
            if(validatePassword(password)){
                if(password.equals(confirmPassword))
                    return true;
            }else{
                return false;
            }
        }
        return false;
    }
    private boolean validateEmptyInputs(String input){
        if(input != null){
            return true;
        }
        System.out.println("empty"+input);
        return false;
    }
    private boolean validateDate(String date){
        if(date != null){
            this.matcher = this.datePattern.matcher(date);
            if (this.matcher.matches()){
                return true;
            }else{
                System.out.println("date not valid");
                return false;
            }
        }
        System.out.println("date not valid");
        return false;

    }

}
