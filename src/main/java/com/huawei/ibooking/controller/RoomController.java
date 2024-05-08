package com.huawei.ibooking.controller;

import com.huawei.ibooking.common.ResponseData;
import com.huawei.ibooking.common.SpringUtil;
import com.huawei.ibooking.model.Room;
import com.huawei.ibooking.model.dto.addRoomReq;
import com.huawei.ibooking.model.dto.updateRoomReq;
import com.huawei.ibooking.service.RoomService;
import org.springframework.beans.BeanUtils;
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
    /***
     * 获取所有房间信息
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    /***
     * 查询指定roomId的房间具体信息
     * @param roomId
     * @return
     */
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomByRoomId(@PathVariable("roomId") String roomId) {
        Room room = roomService.getRoomByRoomId(roomId);
        if (room != null) {
            return new ResponseEntity<>(room,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /***
     * 管理员添加房间信息
     * @param req
     * @return
     */
    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody addRoomReq req) {
        try {
            //首先检查该room是否存在
            Room res = roomService.getRoomByRoomId(req.getRoomId());
            if(res != null){
                return ResponseEntity.ok(new ResponseData(-1, "已经存在"));
            }else{
                //如果存在，添加room，同时设置默认值
                res = new Room();
                SpringUtil.copyPropertiesIgnoreNull(req,res);
                boolean isSuccess = roomService.addRoom(res);
                if (isSuccess) {
                    // 创建一个成功的响应，添加成功
                    return ResponseEntity.ok(new ResponseData(0, "添加成功"));
                } else {
                    // 添加失败
                    return ResponseEntity.ok(new ResponseData(-1, "添加失败"));
                }
            }
        } catch (Exception e) {
            // 创建一个错误响应
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseData(-2, "服务器错误"));
        }
    }

    /***
     * 管理员更新房间信息
     * @param req
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateRoom(@RequestBody updateRoomReq req){
        //检查房间是否存在，并返回房间信息,将更新信息的dto拷贝到room中
        Room res = roomService.getRoomByRoomId(req.getRoomId());
//        System.out.println(req.toString());
//        System.out.println(res.toString());
//        System.out.println(res.toString());
        if(res == null){
            return ResponseEntity.ok(new ResponseData(-1, "房间不存在"));
        }else{
            //更新房间信息，通过传入的room和res进行对比，更新res的值
            SpringUtil.copyPropertiesIgnoreNull(req,res);
            boolean isSuccess = roomService.updateRoom(res);
            if(isSuccess){
                return ResponseEntity.ok(new ResponseData(0, "更新成功"));
            }else{
                return ResponseEntity.ok(new ResponseData(-1, "更新失败"));
            }
        }
    }
    @DeleteMapping(value = "/{roomId}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("roomId") String roomId) {
        boolean result = roomService.deleteRoomByRoomId(roomId);
        if (result) {
            // 删除成功，返回200 OK状态码和成功消息
            return ResponseEntity.ok(new ResponseData(0, "删除成功"));
        } else {
            // 删除失败，返回404 Not Found状态码和错误消息
            return ResponseEntity.ok(new ResponseData(-1, "删除失败"));
        }
    }


}
