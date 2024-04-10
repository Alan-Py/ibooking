package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class SeatReq {
    private String seatId;
    private String roomId;
    private Boolean socket;
    private int startTime = 0;
    private int endTime = 23;
    private Boolean isToday = true;
    private Boolean isEmpty = false;
}
