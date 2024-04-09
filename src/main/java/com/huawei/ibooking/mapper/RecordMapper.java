package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Record;
import org.apache.ibatis.annotations.Mapper;
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
}
