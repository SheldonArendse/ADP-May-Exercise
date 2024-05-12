package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.utils.Helper;

public class ContactFactory {

    public static Contact buildContact(String email, String mobile, String workTelephone) {
        if(Helper.testString(email)
                && Helper.testString(mobile)
                && Helper.testString(workTelephone)
                && Helper.isValidEmail(email)
                && Helper.testValidContact(mobile)
                && Helper.testValidContact(workTelephone)) {

            return new Contact.Builder()
                    .setEmail(email)
                    .setMobile(mobile)
                    .setWorkTelephone(workTelephone)
                    .build();
        }
        return null;
    }

    public static Contact buildContact(String email) {
        if(Helper.isValidEmail(email)) {
            return new Contact.Builder().setEmail(email).build();
        }
        return null;
    }
}
