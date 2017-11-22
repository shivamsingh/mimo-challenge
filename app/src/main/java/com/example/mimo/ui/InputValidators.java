package com.example.mimo.ui;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidators {

    public static class ValidationException extends Exception {
        private Object source;
        private String errorMessage;

        ValidationException(Object source, String errorMessage) {
            super(errorMessage);
            this.source = source;
            this.errorMessage = errorMessage;
        }

        public Object getSource() {
            return source;
        }

        public String getMessage() {
            return errorMessage;
        }
    }

    public static void isValidEmail(Object source, String email, String errorMessage) throws ValidationException {
        isNullOrEmpty(source, email, errorMessage);

        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches())
            throw new ValidationException(source, errorMessage);
    }

    public static void isValidPassword(Object source, String password, String errorMessage) throws ValidationException {
        isNullOrEmpty(source, password, errorMessage);

        if (password.length() < 6)
            throw new ValidationException(source, errorMessage);
    }

    public static void isNullOrEmpty(Object source, String text, String errorMessage) throws ValidationException {
        if (text == null || text.equals(""))
            throw new ValidationException(source, errorMessage);
    }
}
