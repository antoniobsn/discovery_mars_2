package br.com.absn.exception;

import java.io.Serializable;

/**
 * Created by antonio on 23/10/17.
 */
public class ErrorDetail implements Serializable {

    private final String message;

    public ErrorDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
