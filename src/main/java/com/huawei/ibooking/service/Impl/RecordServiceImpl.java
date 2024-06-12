package com.huawei.ibooking.service.Impl;

import com.huawei.ibooking.mapper.RecordMapper;
import com.huawei.ibooking.model.Record;
import com.huawei.ibooking.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private final RecordMapper recordMapper;

    public RecordServiceImpl(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    @Override
    public Record getRecordByRecordId(String recordId) {
        return recordMapper.selectById(recordId);
    }

    @Override
    public boolean updateRecord(Record record) {  return recordMapper.updateById(record) > 0; }

    @Override
    public boolean addRecord(Record record) {
        return recordMapper.insert(record) > 0;
    }

    @Override
    public boolean deleteRecordByRecordId(String recordId) {
        return false;
    }

    @Override
    public List<Record> getRecordListByStuId(String stuId) {
        return recordMapper.getRecordListByStuId(stuId);
    }

    @Override
    public Record getSigninRecord(String stuId, String roomId, String seatId) {
        return recordMapper.getSigninRecord(stuId, roomId, seatId);
    }
}
