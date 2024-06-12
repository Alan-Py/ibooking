package com.huawei.ibooking.controller;
import com.huawei.ibooking.common.ResponseData;
import com.huawei.ibooking.model.Record;
import com.huawei.ibooking.model.dto.signInReq;
import com.huawei.ibooking.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * <p>
 * 记录controller层
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@RestController
@RequestMapping(value = "/api/record")
public class RecordController {
    private final RecordService recordService;
    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }
    /***
     * 获取指定学生的所有订阅记录
     * @param stuId
     * @return
     */
    @GetMapping(value = "/list/{stuId}")
    public ResponseEntity<List<Record>> getRecordListByStuId(@PathVariable String stuId) {
        //通过学生ID查询学生的所有订阅记录
        List<Record> records = recordService.getRecordListByStuId(stuId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    /***
     * 实现签到功能
     * @param signInreq
     * @return
     */
    @PutMapping(value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody signInReq signInreq) {
        //签到
        Record record = recordService.getSigninRecord(signInreq.getStuId(), signInreq.getRoomId(), signInreq.getSeatId());
        if (record == null) {
            return ResponseEntity.ok(new ResponseData(-1, "未找到该条记录"));
        } else {
            LocalTime currentTime = LocalTime.now();
            if (record.getStatus() == 2) {
                return ResponseEntity.ok(new ResponseData(-1, "已签到"));
            }
            LocalTime targetTime = LocalTime.of(record.getStartTime(), 0);
            long minutes = currentTime.until(targetTime, ChronoUnit.MINUTES);
            if (minutes < 30) {
                record.setStatus(2);
                recordService.updateRecord(record);
                return ResponseEntity.ok(new ResponseData(0, "成功"));
            } else {
                return ResponseEntity.ok(new ResponseData(-1, "已超时"));
            }
        }
    }
}