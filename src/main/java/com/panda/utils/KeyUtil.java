package com.panda.utils;

import java.util.Random;

/**
 * 产生时间
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间 + 6位随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer randomResult = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(randomResult);
    }
}
