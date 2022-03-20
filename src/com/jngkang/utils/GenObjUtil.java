package com.jngkang.utils;


import com.jngkang.anno.DataRange;
import com.jngkang.constant.GlobalConst;
import com.jngkang.enumeration.StringTypeEnum;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author JngKang
 * @date 2022-03-19 16:33
 * @description Generate random data from the bytecode file and return.
 */
public class GenObjUtil {
    private GenObjUtil() {
    }

    public static Object build(Class clazz) {
        // Create an object from a bytecode file.
        Object res = null;
        try {
            res = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        // Get all fields (member variables).
        Field[] fields = clazz.getDeclaredFields();
        // Get the corresponding setter method by the field name and assign a random value.
        for (Field field : fields) {
            // Get all the methods corresponding to the field (Getter & Setter methods).
            PropertyDescriptor pd = null;
            try {
                pd = new PropertyDescriptor((String) field.getName(), clazz);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            // Get the setter method corresponding to the field.
            Method method = pd.getWriteMethod();
            // Get all parameters of the setter method.
            Class<?>[] parameterTypes = method.getParameterTypes();
            // Assign different values to different parameters.
            for (Class<?> parameterType : parameterTypes) {
                // Get the annotation on the corresponding parameter in the entity class.
                DataRange annotation = field.getDeclaredAnnotation(DataRange.class);
                if (parameterType == Integer.class) {
                    // If the annotation does not exist, get the default maximum and minimum values.
                    Integer min = GlobalConst.MIN;
                    Integer max = GlobalConst.MAX;
                    // If the annotation exists, get the maximum and minimum values in the annotation.
                    if (annotation != null) {
                        min = annotation.min();
                        max = annotation.max();
                    }
                    // Generate random numbers and assign values.
                    try {
                        method.invoke(res, RandomUtil.genInteger(min, max));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (parameterType == String.class) {
                    // If the annotation does not exist, get the default maximum and minimum values.
                    StringTypeEnum type = GlobalConst.TYPE;
                    Integer minLen = GlobalConst.MIN_LEN;
                    Integer maxLen = GlobalConst.MAX_LEN;
                    // If the annotation exists, get the maximum and minimum values in the annotation.
                    if (annotation != null) {
                        minLen = annotation.minLen();
                        maxLen = annotation.maxLen();
                        type = annotation.type();
                    }
                    // Generate random numbers and assign values.
                    try {
                        if ("CHINESE_NAME".equals(type.getMsg())) {
                            method.invoke(res, RandomUtil.genChineseName());
                        } else if ("EMAIL".equals(type.getMsg())) {
                            method.invoke(res, RandomUtil.genEmail());
                        } else if ("PHONE_NUM".equals(type.getMsg())) {
                            method.invoke(res, RandomUtil.genPhoneNum());
                        } else {
                            method.invoke(res, RandomUtil.genString(type.getCode(), RandomUtil.genInteger(minLen, maxLen)));
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (parameterType == BigDecimal.class) {
                    // If the annotation does not exist, get the default maximum and minimum values.
                    Integer bigMin = GlobalConst.BIG_MIN;
                    Integer bigMax = GlobalConst.BIG_MAX;
                    Integer precision = GlobalConst.PRECISION;
                    // If the annotation exists, get the maximum and minimum values in the annotation.
                    if (annotation != null) {
                        bigMin = annotation.minLen();
                        bigMax = annotation.maxLen();
                        precision = annotation.precision();
                    }
                    // Generate random numbers and assign values.
                    try {
                        StringBuilder sb = new StringBuilder(RandomUtil.genString(StringTypeEnum.PURE_DIGIT.getCode(), (RandomUtil.genInteger(bigMin, bigMax) + precision)));
                        method.invoke(res, new BigDecimal(sb.insert(sb.length() - precision, ".").toString()));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (parameterType == LocalDate.class) {
                    // If the annotation does not exist, get the default maximum and minimum values.
                    String dateMin = GlobalConst.START_DATE;
                    String dateMax = GlobalConst.END_DATE;
                    // If the annotation exists, get the maximum and minimum values in the annotation.
                    if (annotation != null) {
                        dateMin = annotation.startDate();
                        dateMax = annotation.endDate();
                    }
                    // Generate random numbers and assign values.
                    try {
                        method.invoke(res, RandomUtil.genLocalDate(dateMin, dateMax));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (parameterType == LocalDateTime.class) {
                    // If the annotation does not exist, get the default maximum and minimum values.
                    String dateTimeMin = GlobalConst.START_DATE_TIME;
                    String dateTimeMax = GlobalConst.END_DATE_TIME;
                    // If the annotation exists, get the maximum and minimum values in the annotation.
                    if (annotation != null) {
                        dateTimeMin = annotation.startDateTime();
                        dateTimeMax = annotation.endDateTime();
                    }
                    // Generate random numbers and assign values.
                    try {
                        method.invoke(res, RandomUtil.genLocalDateTime(dateTimeMin, dateTimeMax));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }
}
