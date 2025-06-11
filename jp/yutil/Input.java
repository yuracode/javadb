package jp.yutil;

import java.util.Scanner;

// ユーザー入力を処理するためのユーティリティクラス
public class Input {
    // Scannerオブジェクトを共有して使用
    private static final Scanner scanner = new Scanner(System.in);

    // ユーザーにプロンプトを表示してbyte型の入力を取得
    public static byte getByte(String prompt) {
        System.out.print(prompt);
        return getByte();
    }

    // byte型の入力を取得（エラーハンドリング付き）
    public static byte getByte() {
        while (true) {
            try {
                return Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効なbyte値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してshort型の入力を取得
    public static short getShort(String prompt) {
        System.out.print(prompt);
        return getShort();
    }

    // short型の入力を取得（エラーハンドリング付き）
    public static short getShort() {
        while (true) {
            try {
                return Short.parseShort(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効なshort値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してint型の入力を取得
    public static int getInt(String prompt) {
        System.out.print(prompt);
        return getInt();
    }

    // int型の入力を取得（エラーハンドリング付き）
    public static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効な整数値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してlong型の入力を取得
    public static long getLong(String prompt) {
        System.out.print(prompt);
        return getLong();
    }

    // long型の入力を取得（エラーハンドリング付き）
    public static long getLong() {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効なlong値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してfloat型の入力を取得
    public static float getFloat(String prompt) {
        System.out.print(prompt);
        return getFloat();
    }

    // float型の入力を取得（エラーハンドリング付き）
    public static float getFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効なfloat値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してdouble型の入力を取得
    public static double getDouble(String prompt) {
        System.out.print(prompt);
        return getDouble();
    }

    // double型の入力を取得（エラーハンドリング付き）
    public static double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効なdouble値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示してchar型の入力を取得
    public static char getChar(String prompt) {
        System.out.print(prompt);
        return getChar();
    }

    // char型の入力を取得
    public static char getChar() {
        return scanner.nextLine().charAt(0);
    }

    // ユーザーにプロンプトを表示して文字列を取得
    public static String getString(String prompt) {
        System.out.print(prompt);
        return getString();
    }

    // 文字列を取得（前後の改行や空白を除去）
    public static String getString() {
        return scanner.nextLine().trim();
    }

    // ユーザーにプロンプトを表示してboolean型の入力を取得
    public static boolean getBoolean(String prompt) {
        System.out.print(prompt + " (true/false): ");
        return getBoolean();
    }

    // boolean型の入力を取得（エラーハンドリング付き）
    public static boolean getBoolean() {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("無効な入力です。「true」または「false」を入力してください。");
        }
    }

    // ユーザーにプロンプトを表示して16進数の入力を取得
    public static int getHex(String prompt) {
        System.out.print(prompt);
        return getHex();
    }

    // 16進数の入力を取得（エラーハンドリング付き）
    public static int getHex() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine(), 16);
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効な16進数値を入力してください。");
            }
        }
    }

    // ユーザーにプロンプトを表示して2進数の入力を取得
    public static int getBin(String prompt) {
        System.out.print(prompt);
        return getBin();
    }

    // 2進数の入力を取得（エラーハンドリング付き）
    public static int getBin() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine(), 2);
            } catch (NumberFormatException e) {
                System.out.println("無効な入力です。有効な2進数値を入力してください。");
            }
        }
    }
}