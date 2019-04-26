package com.bd.springphoenixhbase.config.annotation;

import java.lang.annotation.*;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HBaseModel {

    /**
     * 表名
     */
    String tableName() default "";
}
