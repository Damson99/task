package com.task.api.validator;

import com.task.api.validator.exceptions.IllegalCharacters;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameValid, String>
{
    @Override
    public void initialize(NameValid nameValid)
    {}

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        return nameIllegalCharacters(s);
    }

    private boolean nameIllegalCharacters(String s)
    {
        Pattern pattern = Pattern.compile("[~@#$%^&*=+{}<>]");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find())
        {
            throw new IllegalCharacters("Illegal characters in field : " + s);
        }
        else
        {
            return true;
        }
    }
}
