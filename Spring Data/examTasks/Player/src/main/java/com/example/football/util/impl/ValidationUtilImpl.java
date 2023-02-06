package com.example.football.util.impl;

import com.example.football.util.ValidationUtil;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private Validator validation = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Override
    public <E> boolean isValid(E entity) {
        return validation.validate(entity).isEmpty();
    }
}
