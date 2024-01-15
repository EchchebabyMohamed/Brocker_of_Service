package com.example.brocker_services_back_end.Exception;

public class PersonneNotFoundException extends RuntimeException{
    public PersonneNotFoundException(String s) {
        super(s);
    }
}
