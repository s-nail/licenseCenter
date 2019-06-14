package com.hundsun.common.annotation;

import com.hundsun.core.aspect.LicenseAuthAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by jiayq24996 on 2019-06-13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LicenseAuthAspect.class)
public @interface EnableLicenseAuthCheck {

}
