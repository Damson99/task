package com.task.api.validator.exceptions;

public class NoDataException extends RuntimeException
{
    public NoDataException()
    {
    }

    public NoDataException(String message)
    {
        super(message);
    }
}
