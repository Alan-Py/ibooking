package com.huawei.ibooking.common;

import lombok.Data;

@Data
// 定义一个简单的响应数据类
public class ResponseData {
    private int errno;
    private String errmsg;

    public ResponseData(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }
}