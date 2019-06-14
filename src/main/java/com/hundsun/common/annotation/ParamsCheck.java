package com.hundsun.common.annotation;

import java.lang.annotation.*;

/**
 * Created by jiayq24996 on 2019-06-05
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsCheck {

    /**
     * 是否忽略
     * 当 ignore = true 时,其他属性设置无效
     *
     * @return
     */
    boolean ignore() default false;

}
