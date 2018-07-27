/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitiy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Windows 10 Version 2
 */
public class ValidateData {

    //VALIDATE NAME
    public boolean validateName(String name) {
        boolean val = true;
        name = name.trim();
        if (name == null || name.equals("")) {  //check for blank input
            System.out.println("Blank input. Please enter name");
            System.out.println();
            val = false;
        } else if (!name.matches("[a-zA-Z\\s]*")) {  //check for name to be character only
            System.out.println("No number or special character allowed");
            System.out.println();
            val = false;
        }
        return val;
    }
    private final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public boolean validateString(String s){
        boolean val = true;
        s = s.trim();
        if(s == null || s.equals("")){
            val = false;
        }
        return val;
    }
}
