package com.huawei.ibooking.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huawei.ibooking.mapper.AdminMapper;
import com.huawei.ibooking.model.Admin;
import com.huawei.ibooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.selectList(null);
    }

    @Override
    public Admin getAdminByAdminId(String adminId) {
        return adminMapper.getAdminByAdminId(adminId);
    }

    @Override
    @Transactional
    public boolean addAdmin(Admin admin) {
        return adminMapper.insert(admin) > 0;
    }

    @Override
    @Transactional
    public boolean updateAdmin(Admin admin) {
        return adminMapper.updateById(admin) > 0;
    }

    @Override
    @Transactional
    public boolean deleteAdminById(String AdminId) {
        return adminMapper.deleteAdminByAdminId(AdminId) > 0;
    }
}
