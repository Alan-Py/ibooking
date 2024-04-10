package com.huawei.ibooking.controller;

import com.huawei.ibooking.model.Seat;
import com.huawei.ibooking.model.dto.SeatReq;
import com.huawei.ibooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;
    //构造函数
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }
    //根据条件搜索当前的seat list
    @GetMapping(value = "/search")
    public ResponseEntity<List<Seat>> getSeatList(
            @RequestParam(required = false) String seatId,
            @RequestParam(required = false) String roomId,
            @RequestParam(required = false) Boolean socket,
            @RequestParam(required = false) int start_time,
            @RequestParam(required = false) int end_time,
            @RequestParam(required = false) Boolean isToday,
            @RequestParam(required = false) Boolean isEmpty)
    {
        SeatReq seatReq = new SeatReq();
        seatReq.setSeatId(seatId);
        seatReq.setRoomId(roomId);
        seatReq.setSocket(socket);
        seatReq.setStartTime(start_time);
        seatReq.setEndTime(end_time);
        seatReq.setIsToday(isToday);
        seatReq.setIsEmpty(isEmpty);
        List<Seat> seatList = seatService.getSeatList(seatReq);
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }
    @GetMapping(value = "/getSeatBySeatId")
    public ResponseEntity<Seat> getSeatBySeatId(@RequestParam String seatId, @RequestParam String roomId){
        Seat seat = seatService.getSeatBySeatId(seatId, roomId);
        if(seat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

}
