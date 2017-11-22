package com.example.mimo.di.scope;

import com.example.mimo.di.AppComponent;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * In Dagger, an unscoped component cannot depend on a scoped component.
 * As {@link AppComponent} is a scoped {@code @Singleton}, we create custom scope
 * to be used by all fragment components.
 * Additionally, a component with specific scope cannot have sub component with same scope}
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScoped {
}
