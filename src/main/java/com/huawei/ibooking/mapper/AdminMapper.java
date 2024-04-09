package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 管理员表Mapper接口
 * </p>
 *
 * @author Panyue
 * @since 2024-04-09
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where admin_id = #{adminId}")
    Admin getAdminByAdminId(String adminId);
    @Delete("delete from admin where admin_id = #{adminId}")
    int deleteAdminByAdminId(String adminId);

}
