package com.jngkang.utils;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * @author JngKang
 * @date 2022-03-19 21:38
 * @description Random tools
 */
public class RandomUtil {

    private static final Random RANDOM = new Random();

    /**
     * @param min minimum value
     * @param max maximum value
     * @return java.lang.Integer
     * @description Randomly generate a specified range of Integer values.
     */
    public static Integer genInteger(Integer min, Integer max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * @return boolean
     * @description Randomly generate a Boolean value.
     */
    public static boolean genBoolean() {
        return RANDOM.nextBoolean();
    }

    /**
     * @param type String type
     * @param len  The length of the string
     * @return java.lang.String
     * @description Random string: 1 pure number, 2 pure lowercase, 3 pure uppercase, 4 uppercase and lowercase, 5 mixed numbers and letters, 6 Chinese character strings.
     */
    public static String genString(Integer type, Integer len) {
        StringBuilder res = new StringBuilder();
        switch (type) {
            case 1:
                for (int i = 0; i < len; i++) {
                    res.append(genInteger(0, 9));
                }
                break;
            case 2:
                for (int i = 0; i < len; i++) {
                    int min = (int) 'a';
                    int max = (int) 'z';
                    int tmp = genInteger(min, max);
                    res.append((char) tmp);
                }
                break;
            case 3:
                for (int i = 0; i < len; i++) {
                    int min = (int) 'A';
                    int max = (int) 'Z';
                    int tmp = genInteger(min, max);
                    res.append((char) tmp);
                }
                break;
            case 4:
                for (int i = 0; i < len; i++) {
                    int min = (int) 'A';
                    int max = (int) 'z';
                    int tmp = genInteger(min, max);
                    if (tmp >= 91 && tmp <= 96) {
                        i--;
                        continue;
                    }
                    res.append((char) tmp);
                }
                break;
            case 5:
                for (int i = 0; i < len; i++) {
                    int min = (int) '0';
                    int max = (int) 'z';
                    int tmp = genInteger(min, max);
                    if ((tmp >= 91 && tmp <= 96) || (tmp >= 58 && tmp <= 64)) {
                        i--;
                        continue;
                    }
                    res.append((char) tmp);
                }
                break;
            case 6:
                for (int i = 0; i < len; i++) {
                    res.append(genRandomChineseChar());
                }
                break;
            default:
                throw new RuntimeException("Type error.");
        }
        return res.toString();
    }

    /**
     * @return java.lang.String
     * @description Generate mailboxes of random length.
     */
    public static String genEmail() {
        String[] emails = {"@163.com", "@126.com", "@139.com", "@189.com", "@qq.com", "@vip.sina.com", "@sina.cn", "@sina.com", "@sohu.com", "@hotmail.com", "@gmail.com", "@wo.com.cn", "@21cn.com", "@aliyun.com", "@yahoo.com", "@foxmail.com",};
        String tmp1 = genString(5, genInteger(6, 18));
        String tmp2 = emails[genInteger(0, emails.length - 1)];
        return tmp1 + tmp2;
    }

    /**
     * @return java.lang.String
     * @description Randomly generate phone numbers.
     */
    public static String genPhoneNum() {
        String[] prefix = {"132", "133", "134", "135", "136", "138", "139", "152", "154", "155", "177", "188"};
        int index = genInteger(0, prefix.length - 1);
        String res = prefix[index] + genString(1, 8);
        return res;
    }

    /**
     * @return java.lang.Character
     * @description Randomly generate a common Chinese character.
     */
    private static Character genRandomChineseChar() {
        String str = "";
        Random random = new Random();

        int heightPos = (176 + Math.abs(random.nextInt(39)));
        int lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(heightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        return str.charAt(0);
    }

    /**
     * @return java.lang.String
     * @description Randomly generate Chinese names.
     */
    public static String genChineseName() {
        Random random = new Random();
        String firstNames = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季";
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

        int index = random.nextInt(firstNames.length() - 1);
        // Get a random last name
        String name = "" + firstNames.charAt(index);
        // The ratio of male to female can be set according to this number.
        int i = random.nextInt(3);
        int j = random.nextInt(girl.length() - 2);
        if (i == 2) {
            if (j % 2 == 0) {
                name = name + girl.substring(j, j + 2);
            } else {
                name = name + girl.charAt(j);
            }
        } else {
            if (j % 2 == 0) {
                name = name + boy.substring(j, j + 2);
            } else {
                name = name + boy.charAt(j);
            }

        }
        return name;
    }

    /**
     * @param min Start date，for example: 2000-3-3 8:5:3
     * @param max End date，for example: 2004-12-12 12:12:12
     * @return java.time.LocalDateTime
     * @description Generate random datetime in specified range.
     */
    public static LocalDateTime genLocalDateTime(String min, String max) {
        if (!(min.contains(" ") || min.contains("-") || min.contains(":"))) {
            throw new RuntimeException("Date parameter format is incorrect.");
        }
        if (!(max.contains(" ") || max.contains("-") || max.contains(":"))) {
            throw new RuntimeException("Date parameter format is incorrect.");
        }
        String[] mins = min.split("[ ,\\-,:]");
        String[] maxs = max.split("[ ,\\-,:]");

        LocalDateTime localDateTimeMin = LocalDateTime.of(Integer.parseInt(mins[0]), Integer.parseInt(mins[1]), Integer.parseInt(mins[2]), Integer.parseInt(mins[3]), Integer.parseInt(mins[4]), Integer.parseInt(mins[5]));
        LocalDateTime localDateTimeMax = LocalDateTime.of(Integer.parseInt(maxs[0]), Integer.parseInt(maxs[1]), Integer.parseInt(maxs[2]), Integer.parseInt(mins[3]), Integer.parseInt(mins[4]), Integer.parseInt(mins[5]));

        // Get the number corresponding to the date.
        long timeMin = localDateTimeMin.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long timeMax = localDateTimeMax.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        double random = Math.random();
        long digit = (long) (random * (timeMax - timeMin + 1) + timeMin);

        LocalDateTime res = LocalDateTime.ofInstant(Instant.ofEpochMilli(digit), ZoneOffset.of("+8"));

        return res;
    }

    /**
     * @param min Start date，for example: 2000-3-3
     * @param max End date，for example: 2004-12-12
     * @return java.time.LocalDate
     * @description Generate random dates within a specified range.
     */
    public static LocalDate genLocalDate(String min, String max) {
        if (!min.contains("-")) {
            throw new RuntimeException("Date parameter format is incorrect.");
        }
        if (!max.contains("-")) {
            throw new RuntimeException("Date parameter format is incorrect.");
        }
        min += " 0:0:0";
        max += " 23:59:59";
        LocalDateTime res = genLocalDateTime(min, max);

        return res.toLocalDate();
    }

}