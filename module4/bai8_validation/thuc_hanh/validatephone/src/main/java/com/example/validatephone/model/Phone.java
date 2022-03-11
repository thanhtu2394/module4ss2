package com.example.validatephone.model;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Phone implements Validator {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Phone.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Phone phone = (Phone) target;
        String number = phone.number;
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length() < 10 || number.length() > 11) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
//        Phone phoneNumber = (Phone) target;
//        String number = phoneNumber.getNumber();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
//        if (number.length()>11 || number.length()<10){
//            errors.rejectValue("number", "number.length");
//        }
//        if (!number.startsWith("0")){
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!number.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number", "number.matches");
//        }
    }
}
