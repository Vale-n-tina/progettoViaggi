package com.example.progettoViaggi.exceptions;


import lombok.Data;

@Data
public class Error {

    private String message;
    private int status;
    private String details;


}
