package com.tools;

import java.util.Scanner;

public class InputUtil {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * 输入整数
     *
     * @param prompt 输入提示信息
     * @return 输入的整数
     */
    public static int inputInt(String prompt) {
        while (true) {
            if (prompt.length() != 0){
                System.out.print(prompt + ":");
            }
            if (scanner.hasNextInt()) {
                int intNumber = scanner.nextInt();
                return intNumber;
            } else {
                System.out.println("您输入的不是整数 ");
                scanner.next();
                continue;
            }
        }

    }

    /**
     * 输入字符串
     *
     * @param prompt
     * @return
     */
    public static String inputStr(String prompt) {
        if (prompt.length() != 0){
            System.out.print(prompt + ":");
        }
        return InputUtil.scanner.next();
    }
}
