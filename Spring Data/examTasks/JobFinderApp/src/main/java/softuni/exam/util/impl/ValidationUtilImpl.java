package softuni.exam.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.util.ValidationUtil;

import javax.validation.Validation;
import javax.validation.Validator;

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
        for (T c : enumerator.getEnumConstants()) {
            if (c.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
