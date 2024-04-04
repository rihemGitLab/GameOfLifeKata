package com.kata.gameoflife.exception;


public class InvalidCellStateException extends RuntimeException {
    public InvalidCellStateException(String message) {
        super(message);
    }
}
