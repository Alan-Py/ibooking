package com.huawei.ibooking.controller;

import com.huawei.ibooking.model.Room;
import com.huawei.ibooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 教室controller层
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    // 获取所有房间信息

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    // 根据房间ID查询房间信息
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomByRoomId(@PathVariable("roomId") String roomId) {
        Room room = roomService.getRoomByRoomId(roomId);
        if (room != null) {
            return new ResponseEntity<>(room,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // 添加房间信息
    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        try {
            boolean isSuccess = roomService.addRoom(room);
            if (isSuccess) {
                // 创建一个成功的响应
                return new ResponseEntity<>("Room added successfully", HttpStatus.OK);
            } else {
                // 创建一个失败的响应
                return new ResponseEntity<>("Failed to add Room", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // 创建一个错误响应
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // 更新房间信息
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateRoom(@RequestBody Room room){
        boolean isSuccess = roomService.updateRoom(room);
        if (isSuccess) {
            return new ResponseEntity<>("Room updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Room not found or update failed", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/{roomId}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("roomId") String roomId) {
        boolean result = roomService.deleteRoomByRoomId(roomId);
        if (result) {
            // 删除成功，返回200 OK状态码和成功消息
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        } else {
            // 删除失败，返回404 Not Found状态码和错误消息
            return new ResponseEntity<>("Room not found or delete failed", HttpStatus.NOT_FOUND);
        }
    }


}
