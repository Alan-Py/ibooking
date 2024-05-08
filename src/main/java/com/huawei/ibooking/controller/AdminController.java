package com.huawei.ibooking.controller;
import com.huawei.ibooking.common.ResponseData;
import com.huawei.ibooking.model.Admin;
import com.huawei.ibooking.model.dto.AdminReq;
import com.huawei.ibooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 * 管理员controller层
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
//    @PostMapping("/login")

    // 获取所有管理员信息
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
    // 根据管理员ID查询管理员信息
    @GetMapping("/{adminId}")
    public ResponseEntity<Admin> getAdminByAdminId(@PathVariable("adminId") String adminId) {
        Admin admin = adminService.getAdminByAdminId(adminId);
        if (admin != null) {
            //如果管理员存在
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            //返回为找到管理员
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // 添加管理员信息
    @PostMapping
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        try{
            boolean isSuccess = adminService.addAdmin(admin);
            if (isSuccess) {
                return new ResponseEntity<>("admin added successfully", HttpStatus.OK);
            } else {
                // 创建一个失败的响应
                return new ResponseEntity<>("Failed to add admin", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            // 创建一个错误响应
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    // 更新管理员信息
    @PutMapping
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) {
        boolean isSuccess = adminService.updateAdmin(admin);
        if (isSuccess) {
            // 更新成功，返回200 OK状态码和成功消息
            return new ResponseEntity<>("admin updated successfully", HttpStatus.OK);
        } else {
            // 更新失败，返回404 Not Found状态码和错误消息
            return new ResponseEntity<>("admin not found or update failed", HttpStatus.NOT_FOUND);
        }
    }
    // 删除管理员信息
    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdminById(@PathVariable String adminId) {
        boolean isSuccess = adminService.deleteAdminById(adminId);
        if (isSuccess) {
            return new ResponseEntity<>("admin deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("admin not found or delete failed", HttpStatus.NOT_FOUND);
        }
    }

    /***
     * 管理员登录
     * @param req
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminReq req) {
        Admin admin1 = adminService.getAdminByAdminId(req.getAdminId());
        if (admin1 != null && admin1.getPassword().equals(req.getPassword())) {
            // 返回student信息以及0表示成功
            return ResponseEntity.ok(new ResponseData(0, "成功"));
        } else {
            //返回状态码-1，用户名密码错误
            return ResponseEntity.ok(new ResponseData(-1, "用户名或密码错误"));
        }
    }

}
