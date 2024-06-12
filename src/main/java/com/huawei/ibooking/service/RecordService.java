package com.huawei.ibooking.service;

import com.huawei.ibooking.model.Record;

import java.util.List;

/**
 * <p>
 * 预订表Service接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
public interface RecordService {
    //查看当前预订
    Record getRecordByRecordId(String recordId);
    // 更新预订信息
    boolean updateRecord(Record record);
    // 添加预订信息
    boolean addRecord(Record record);
    // 删除预订信息
    boolean deleteRecordByRecordId(String recordId);
    // 根据学生id查询预订信息
    List<Record> getRecordListByStuId(String stuId);
    // 根据信息查询待签到记录
    Record getSigninRecord(String stuId, String roomId, String seatId);
}
