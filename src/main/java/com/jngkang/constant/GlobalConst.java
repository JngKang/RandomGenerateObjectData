package com.jngkang.constant;

import com.jngkang.enumeration.StringTypeEnum;

/**
 * @author JngKang
 * @date 2022-03-19 17:39
 * @description The global constant controls the initial value of the random value, and the value in the annotation is consistent with this.
 */
public interface GlobalConst {
    /**
     * Integer min value
     */
    Integer MIN = 0;
    /**
     * Integer max value
     */
    Integer MAX = 100;
    /**
     * type of string
     */
    StringTypeEnum TYPE = StringTypeEnum.LETTER_LOWER_UPPER;
    /**
     * String min length
     */
    Integer MIN_LEN = 6;
    /**
     * String max length
     */
    Integer MAX_LEN = 12;
    /**
     * BigDecimal min length
     */
    Integer BIG_MIN = 2;
    /**
     * BigDecimal max length
     */
    Integer BIG_MAX = 2;
    /**
     * BiaDecimal precision
     */
    Integer PRECISION = 2;
    /**
     * LocalDate min date
     */
    String START_DATE = "2000-1-1";
    /**
     * LocalDate max date
     */
    String END_DATE = "2020-12-31";
    /**
     * LocalDate min dateTime
     */
    String START_DATE_TIME = "2000-1-1 0:0:0";
    /**
     * LocalDate max dateTime
     */
    String END_DATE_TIME = "2020-12-31 0:0:0";
}
