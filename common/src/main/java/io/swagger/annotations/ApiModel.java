package io.swagger.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiModel {

    String value() default "";

    String description() default "";

    Class<?> parent() default Void.class;

    String discriminator() default "";

    Class<?>[] subTypes() default {};

    String reference() default "";

}
