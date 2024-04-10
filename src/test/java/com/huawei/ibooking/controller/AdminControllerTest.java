//package com.huawei.ibooking.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.huawei.ibooking.model.Admin;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//import com.fasterxml.jackson.core.type.TypeReference;
//public class AdminControllerTest {
//    private final String url = "/api/admin";
//    @Autowired
//    private AdminController adminController;
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getAllAdmins() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        final List<Admin> students = new ObjectMapper().readValue(
//                mvcResult.getResponse().getContentAsString(), new TypeReference<List<Admin>>() {
//                });
//
//        Assert.assertEquals(students.size(), 3);
//    }
//
//    @Test
//    public void getAdminByAdminId() {
//    }
//
//    @Test
//    public void addAdmin() {
//    }
//
//    @Test
//    public void updateAdmin() {
//    }
//
//    @Test
//    public void deleteAdminById() {
//    }
//}