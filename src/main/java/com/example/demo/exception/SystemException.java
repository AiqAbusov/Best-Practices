package com.example.demo.exception;

import java.util.HashMap;
import java.util.ResourceBundle;

public class SystemException extends RuntimeException {

    private Errors errors;

    private HashMap<String, Object> map;


    public SystemException(Errors errors) {
        map = new HashMap<>();
        this.errors = errors;
    }


    public SystemException set(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public HashMap<String, Object> getProperties() {
        return this.map;
    }

    public SystemException(Errors errors,Throwable throwable) {
       super(throwable.getMessage());
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public String getErrorText(Errors errors) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ExceptionMessages");
        return resourceBundle.getString(errors.getName());
    }

}
