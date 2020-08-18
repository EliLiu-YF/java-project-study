package com.javase.day0725;

import java.util.Arrays;

public class HomeWork {
    /**
     * 统计find 在str中出现的次数
     *
     * @param str
     * @param find
     * @return
     */
    public static int calcTimes(String str, String find) {
        int times = 0;
        int index = -1;
        while (true) {
            index = str.indexOf(find, index + 1);
            if (index == -1) {
                break;
            }
            ++times;
        }
        return times;
    }

    /**
     * 判断邮箱格式是否合法
     *
     * @param email
     * @return
     */
    public static boolean isLegalEmail(String email) {
        boolean isLegal = false;
        if (email.indexOf(".") != -1
                && calcTimes(email, "@") == 1
                && (email.indexOf(".") - email.indexOf("@") > 2)
                && (email.lastIndexOf("com") == email.length() - 3)) {
            isLegal = true;
        }
        return isLegal;
    }

    /**
     * 查找find在str中的位置
     * @param str
     * @param find
     * @return
     */
    public static int[] findIndex(String str, String find) {
        int[] indexArr = new int[0];
        int size = 0;
        int index = -1;
        while (true) {
            if (str.indexOf(find, index + 1) == -1) {
                break;
            }
            if (size >= indexArr.length) {
                indexArr = Arrays.copyOf(indexArr, indexArr.length + 1);
            }
            index = str.indexOf(find, index + 1);
            indexArr[size] = index;
            ++size;
        }
        if (indexArr.length == 0) {
            return null;
        }
        return indexArr;
    }

    public static void main(String[] args) {
        System.out.println(calcTimes("abcabcaaca", "d"));
//        System.out.println(isLegalEmail("1111@qq.com"));
//        System.out.println(Arrays.toString(findIndex("abcabcaaa", "a")));
    }
}
