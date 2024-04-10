package com.huawei.ibooking.service;

import com.huawei.ibooking.model.Admin;
import java.util.List;
/**
 * <p>
 * 管理员表Service接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */

public interface AdminService {
    // 获取所有管理员信息
    List<Admin> getAllAdmins();

    // 根据管理员ID查询管理员信息
    Admin getAdminByAdminId(String adminId);

    // 添加管理员信息
    boolean addAdmin(Admin admin);

    // 更新管理员信息
    boolean updateAdmin(Admin admin);

    // 删除管理员信息
    boolean deleteAdminById(String adminId);
}
