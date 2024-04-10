//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.huawei.ibooking.controller.AdminController;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@WebMvcTest(AdminController.class)
//public class AdminControllerTest{
//    private final String url = "/api/admin";
//    protected LogWrapper logger = LogWrapperFactory.getLogWrapper(BaseSpringBootTest.class);
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private AdminController adminController;
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
//    }
//    @Test
//    public void demo() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("url"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        logger.info(mvcResult.getResponse().getContentAsString());
//    }
//
//}