package moratorium.se.itmo.blps.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ArrayUtils;

public class ValueValidator implements ConstraintValidator<Value, Object> {
    private String[] values;

    @Override
    public void initialize(final Value constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        return ArrayUtils.contains(this.values, value == null ? null : value.toString());
    }
}