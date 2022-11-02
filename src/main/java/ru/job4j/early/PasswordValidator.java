package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty,"
                    + " 12345, password, admin, user");
        }
        char[] text = password.toCharArray();
        boolean special = false;
        for (char ch : text) {
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                special = true;
                break;
            }
            }
            if (!special) {
                throw new IllegalArgumentException("Password should contain at least one special symbol");
            }
        boolean num = true;
        for (char ch : text) {
            if (Character.isDigit(ch)) {
                num = false;
                break;
            }
        }
            if (num) {
                throw new IllegalArgumentException("Password should contain at least one figure");
            }
        return password;
        }
        }







