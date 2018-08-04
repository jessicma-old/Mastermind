package edu.neu.ccs.cs5004.mvc.model;

/**
 * Created by jessicamalloy on 4/5/17.
 */
public class InvalidGuessException extends RuntimeException {

    public InvalidGuessException(String message) {
        super(message);
    }
}
