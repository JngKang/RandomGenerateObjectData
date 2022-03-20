package com.jngkang.anno;

import com.jngkang.enumeration.StringTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JngKang
 * @date 2022-03-19 16:29
 * @description custom annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataRange {
    /**
     * Integer min value
     */
    int min() default 0;

    /**
     * Integer max value
     */
    int max() default 100;

    /**
     * type of string
     */
    StringTypeEnum type() default StringTypeEnum.LETTER_LOWER_UPPER;

    /**
     * String min length
     */
    int minLen() default 6;

    /**
     * String max length
     */
    int maxLen() default 12;

    /**
     * BigDecimal min length
     */
    int bigMin() default 2;

    /**
     * BigDecimal max length
     */
    int bigMax() default 2;

    /**
     * BiaDecimal precision
     */
    int precision() default 2;

    /**
     * LocalDate start date
     */
    String startDate() default "2000-1-1";

    /**
     * LocalDate end date
     */
    String endDate() default "2020-12-31";

    /**
     * LocalDate start dateTime
     */
    String startDateTime() default "2000-1-1 0:0:0";

    /**
     * LocalDate end dateTime
     */
    String endDateTime() default "2020-12-31 0:0:0";
}
