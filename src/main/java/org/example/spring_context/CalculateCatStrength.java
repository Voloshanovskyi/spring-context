package org.example.spring_context;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CalculateCatStrength {
    int minStrength();
    int maxStrength();
}
