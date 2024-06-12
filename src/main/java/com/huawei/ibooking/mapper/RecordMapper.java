package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 预约记录表Mapper接口
 * </p>
 *
 * @author Panyue
 * @since 2024-04-09
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    // 根据学生id查询预订信息
    @Select("select * from record where stu_id = #{stuId}")
    List<Record> getRecordListByStuId(String stuId);
    // 查询带签到的记录
    @Select("select * from record where stu_id = #{stuId} and room_id = #{roomId} and seat_id = #{seatId}")
    Record getSigninRecord(String stuId, String roomId, String seatId);
}
