package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class bookSeatReq {
    private String seatId;
    private String roomId;
    private String stuId;
    private Integer startTime;
    private Integer endTime;
    private Boolean isToday;
}
