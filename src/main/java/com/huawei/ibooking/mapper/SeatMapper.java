package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Seat;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 座位表Mapper接口
 * </p>
 *
 * @author Panyue
 * @since 2024-04-09
 */
@Mapper
public interface SeatMapper extends BaseMapper<Seat> {
}
