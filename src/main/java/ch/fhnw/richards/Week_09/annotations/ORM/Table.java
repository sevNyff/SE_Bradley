package ch.fhnw.richards.Week_09.annotations.ORM;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD}) // Applies to classes and attributes
@Retention(RetentionPolicy.RUNTIME) // Annotation will be processed at runtime
public @interface Table {
    String name() default "";
}
