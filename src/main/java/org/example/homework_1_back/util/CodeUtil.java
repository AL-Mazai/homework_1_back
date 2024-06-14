package org.example.homework_1_back.util;

import java.util.Random;
import java.util.UUID;

public class CodeUtil {
    public static String codeRes = "123456789qwertyuiopasdfghjklzxcvbnm";

    public static String createCode() {
        String res = "";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            res += codeRes.charAt(r.nextInt(codeRes.length() - 1));
        }
        return res;
    }

    public static int generateUniqueId() {
        // 注意：这种方法会丢失UUID的大部分唯一性，仅作示例
        UUID uuid = UUID.randomUUID();
        long leastSigBits = uuid.getLeastSignificantBits();
        return (int) (leastSigBits ^ (leastSigBits >>> 32)); // 截断为int范围
    }
}
