package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) {
            return false;
        }

        // Define the regex pattern for validating EPAM emails
        String regex = "^[a-zA-Z]+_[a-zA-Z]+(?:\\d*)@epam\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern
        return matcher.matches();
    }
}
