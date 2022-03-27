package gov.iti.jets.shoppy.presentation.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Validator validator = new Validator();
    private Matcher matcher ;
    private Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private Pattern passwordPattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
    //Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters

    private Validator(){}

    public static Validator getInstance(){
        return validator;
    }

    public boolean isEmail(String email){
        this.matcher = this.emailPattern.matcher(email);
        if (this.matcher.matches()){
            return true;
        }
        return false;
    }

    public boolean validatePassword(String password){
        this.matcher = this.passwordPattern.matcher(password);
        if (this.matcher.matches()){
            return true;
        }
        return false;
    }
}
