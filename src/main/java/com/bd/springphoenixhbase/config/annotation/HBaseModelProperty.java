package com.bd.springphoenixhbase.config.annotation;

import java.lang.annotation.*;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HBaseModelProperty {

    /**
     * 列簇名
     */
    String family() default "";

    /**
     * 列名
     */
    String qualifier() default "";

    /**
     * 时间戳
     */
    boolean timestamp() default false;
}
