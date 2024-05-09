package com.huawei.ibooking.controller;

import com.huawei.ibooking.common.ResponseData;
import com.huawei.ibooking.model.Record;
import com.huawei.ibooking.model.Room;
import com.huawei.ibooking.model.Seat;
import com.huawei.ibooking.model.dto.SeatReq;
import com.huawei.ibooking.model.dto.bookSeatReq;
//import com.huawei.ibooking.service.RecordService;
import com.huawei.ibooking.service.RoomService;
import com.huawei.ibooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private RoomService roomService;
//    @Autowired
//    private RecordService recordService;
    //构造函数
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    /***
     * 根据条件搜索当前的seat list
     * @param seatId
     * @param roomId
     * @param socket
     * @param startTime
     * @param endTime
     * @param isToday
     * @param isEmpty
     * @return
     */
    @GetMapping(value = "/search")
    public ResponseEntity<List<Seat>> getSeatList(
            @RequestParam(required = false) String seatId,
            @RequestParam(required = false) String roomId,
            @RequestParam(required = false) Boolean socket,
            @RequestParam(value = "start_time", required = false) Integer startTime,
            @RequestParam(value = "end_time",required = false) Integer endTime,
            @RequestParam(required = false) Boolean isToday,
            @RequestParam(required = false) Boolean isEmpty)
    {
        SeatReq seatReq = new SeatReq(seatId,roomId,socket,startTime,endTime,isToday,isEmpty);
        seatReq.setSeatId(seatId);
        seatReq.setRoomId(roomId);
        seatReq.setSocket(socket);
        System.out.println(seatReq.toString());
        List<Seat> seatList = seatService.getSeatList(seatReq);
        if(seatList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(seatList, HttpStatus.OK);
        }

    }

    /**
     * 根据seatId和roomId获取座位详细信息
     * @param seatId
     * @param roomId
     * @return
     */
    @GetMapping(value = "/getSeatBySeatId")
    public ResponseEntity<Seat> getSeatBySeatId(@RequestParam String seatId, @RequestParam String roomId){
        Seat seat = seatService.getSeatBySeatId(seatId, roomId);
        if(seat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
//
//    @PostMapping(value = "/bookSeat")
//    public ResponseEntity<?> bookSeat(@RequestParam bookSeatReq req){
//        // 首先根据seatId和roomId确定座位
//        Seat seat = seatService.getSeatBySeatId(req.getSeatId(), req.getRoomId());
//        if(seat == null){
//            return ResponseEntity.ok(new ResponseData(-1, "座位未找到"));
//        }else{
//            // 根据roomId获取room信息，用来判断开放时间和结束时间
//            Room room = roomService.getRoomByRoomId(req.getRoomId());
//            if(req.getStartTime() < room.getOpenTime() || req.getEndTime() > room.getCloseTime()){
//                return ResponseEntity.ok(new ResponseData(-1, "预订时间不在开放时间内"));
//            }
//            if(req.getStartTime() >= req.getEndTime()){
//                return ResponseEntity.ok(new ResponseData(-1, "预订时间不合法"));
//            }
//            if(req.getEndTime() - req.getStartTime() > room.getMaxBookingTime()){
//                return ResponseEntity.ok(new ResponseData(-1, "超过最大预订时间"));
//            }
//            // 判断该时间段座位是否为空
//            // 今天预订判断今天的时间
//            if(req.getIsToday()){
//                if(seat.getTodayBook().substring(req.getStartTime(),req.getEndTime()).contains("1")){
//                    return ResponseEntity.ok(new ResponseData(-1, "该时间段座位已被预订"));
//                }else{
//                    // 更新座位状态，将预订计入到预订表中
//                    StringBuilder sb = new StringBuilder(seat.getTodayBook());
//                    // 遍历索引i到j，将每个字符改为1
//                    for (int k = req.getStartTime(); k <= req.getEndTime(); k++) {
//                        sb.setCharAt(k, '1');
//                    }
//                    // 将StringBuilder对象转换回字符串
//                    String modifiedString = sb.toString();
//                    seat.setTodayBook(modifiedString);
//                    if(seatService.updateSeat(seat)){
//                        // 将订阅记录写入预订表中
//                        recordService.addRecord(new Record(req.getSeatId(), req.getRoomId(), req.getStuId(),))
//                        return ResponseEntity.ok(new ResponseData(0, "预定成功"));
//                    }else {
//                        return ResponseEntity.ok(new ResponseData(-1, "预定失败"));
//                    }
//                }
//            }else{
//                // 非今天预订判断明天的时间
//                if(seat.getNextBook().substring(req.getStartTime(),req.getEndTime()).contains("1")){
//                    return ResponseEntity.ok(new ResponseData(-1, "该时间段座位已被预订"));
//                }else{
//
//                }
//
//            }
//            seat.getTodayBook()
//            if(seat.getIsBooked()){
//                return ResponseEntity.ok(new ResponseData(-1, "座位已被占用"));
//            }else{
//                // 更新座位状态
//                seat.setIsBooked(true);
//                seat.setBookedTime(req.getBookedTime());
//                seat.setBookedUser(req.getBookedUser());
//                seatService.updateSeat(seat);
//                return ResponseEntity.ok(new ResponseData(0, "预定成功"));
//            }
//        }
//    }
}
