package com.huawei.ibooking.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    // 定义日期格式
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 获取当前日期并格式化
    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DATE_FORMATTER);
    }

}
