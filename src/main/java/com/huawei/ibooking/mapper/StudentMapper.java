package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生表Mapper接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
