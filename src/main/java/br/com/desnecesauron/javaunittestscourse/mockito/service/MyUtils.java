package br.com.desnecesauron.javaunittestscourse.mockito.service;

public class MyUtils {

    public static String getWelcomeMessage(String username, boolean isCustomer) {
        if (isCustomer) {
            return "Welcome dear " + username + " to our platform!";
        } else {
            return "Welcome " + username + " to our platform, we hope you enjoy our services!";
        }
    }
}
