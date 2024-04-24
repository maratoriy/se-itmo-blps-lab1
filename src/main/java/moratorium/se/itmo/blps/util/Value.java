package moratorium.se.itmo.blps.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValueValidator.class})
@Documented
public @interface Value {
    public String message() default "должно являться реальной ролью";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public String[] values() default {};
}