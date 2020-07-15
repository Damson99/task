package com.task.api.validator.exceptions;

public class IllegalCharacters extends RuntimeException
{
    public IllegalCharacters() {
    }

    public IllegalCharacters(String message) {
        super(message);
    }
}
