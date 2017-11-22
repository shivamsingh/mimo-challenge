package com.example.mimo.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputValidatorsTest {

    @Test
    public void InputValidators_isValidEmail_CorrectEmail() {
        Exception ex = null;
        String email = "shvmsngh91@gmail.com";
        try {
            InputValidators.isValidEmail(null, email, "");
        } catch (InputValidators.ValidationException e) {
            ex = e;
        }

        assertEquals(ex, null);
    }

    @Test(expected = InputValidators.ValidationException.class)
    public void InputValidators_isValidEmail_WrongEmail() throws InputValidators.ValidationException {
        String email = "shvmsngh91gmail.com";
        InputValidators.isValidEmail(null, email, "");
    }

    @Test
    public void InputValidators_isValidPassword_CorrectPassword() {
        Exception ex = null;
        String errorMessage = "Invalid password";
        try {
            InputValidators.isValidPassword(null, "123456", errorMessage);
        } catch (InputValidators.ValidationException e) {
            ex = e;
        }

        assertEquals(ex, null);
    }

    @Test(expected = InputValidators.ValidationException.class)
    public void InputValidators_isValidPassword_WrongPassword() throws InputValidators.ValidationException {
        String errorMessage = "Invalid password";
        InputValidators.isValidPassword(null, "12345", errorMessage);
    }

    @Test
    public void InputValidators_isNullOrEmpty_NotNullOrEmptyText(){
        Exception ex = null;
        try {
            InputValidators.isNullOrEmpty(null, "not null/empty text", "");
        } catch (InputValidators.ValidationException e) {
            ex = e;
        }

        assertEquals(ex, null);
    }

    @Test(expected = InputValidators.ValidationException.class)
    public void InputValidators_isNullOrEmpty_NullText() throws InputValidators.ValidationException {
        InputValidators.isNullOrEmpty(null, null, "");
    }

    @Test(expected = InputValidators.ValidationException.class)
    public void InputValidators_isNullOrEmpty_EmptyText() throws InputValidators.ValidationException {
        InputValidators.isNullOrEmpty(null, "", "");
    }
}