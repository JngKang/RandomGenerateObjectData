package com.jngkang.enumeration;

/**
 * @author JngKang
 * @date 2022-03-19 16:29
 * @description The type of the generated string.
 */
public enum StringTypeEnum {
    /**
     * 1-pure numbers
     */
    PURE_DIGIT(1, "PURE_DIGIT"),
    /**
     * 2-pure lowercase
     */
    LETTER_LOWERCASE(2, "LETTER_LOWERCASE"),
    /**
     * 3-pure uppercase
     */
    LETTER_UPPERCASE(3, "LETTER_UPPERCASE"),
    /**
     * 4-lowercase and uppercase
     */
    LETTER_LOWER_UPPER(4, "LETTER_LOWER_UPPER"),
    /**
     * 5-Mix of numbers and letters
     */
    DIGIT_LETTER(5, "DIGIT_LETTER"),
    /**
     * 6-Chinese character string
     */
    CHINESE(6, "CHINESE"),
    /**
     * 7-Chinese name
     */
    CHINESE_NAME(7, "CHINESE_NAME"),
    /**
     * 8-random mailbox
     */
    EMAIL(8, "EMAIL"),
    /**
     * 9-random phone number
     */
    PHONE_NUM(9, "PHONE_NUM"),
    ;
    private Integer code;
    private String msg;

    StringTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
