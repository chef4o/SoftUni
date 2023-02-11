package softuni.exam.util.impl;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;
import softuni.exam.util.ValidationUtil;

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
