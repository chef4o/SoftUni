package exam.util.impl;

import javax.validation.Validation;
import javax.validation.Validator;
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

    @Override
    public <T extends Enum<T>> boolean enumContains(Class<T> enumerator, String value) {
        return false;
    }
}
