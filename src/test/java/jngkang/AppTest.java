package jngkang;

import com.jngkang.utils.GenObjUtil;

/**
 * @author JngKang
 * @date 2022-03-19 17:14
 * @description Test
 */
public class AppTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(GenObjUtil.build(Emp.class));
        }
    }
}
