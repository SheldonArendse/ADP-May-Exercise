package za.ac.cput.utils;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static boolean testLong(Long check) {
        return check != null;
    }

    public static boolean testString(String check) {
        return check != null && !check.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    // Checking that only numbers from 0-9 can be inputted
    // Length of string must be 10 characters long
    public static boolean testValidContact(String contactNum) {
        String regexPattern = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(contactNum);
        return matcher.matches();
    }

    public static boolean testContact(Contact obj) {
        return obj != null;
    }
    public static boolean testEmployee(Employee obj) {
        return obj != null;
    }

    public static Long generateId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
