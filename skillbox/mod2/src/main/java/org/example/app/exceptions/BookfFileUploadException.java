package org.example.app.exceptions;

public class BookfFileUploadException extends Exception {
    private final String message;

    public BookfFileUploadException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
