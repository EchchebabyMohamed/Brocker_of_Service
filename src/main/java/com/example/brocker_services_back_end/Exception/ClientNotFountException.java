package com.example.brocker_services_back_end.Exception;

public class ClientNotFountException extends RuntimeException{
    public ClientNotFountException(String clientNonTrouver) {
        super(clientNonTrouver);
    }
}
