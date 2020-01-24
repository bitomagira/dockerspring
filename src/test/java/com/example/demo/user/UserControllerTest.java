//package com.example.demo.user;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.reset;
//import static org.mockito.Mockito.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value=UserController.class)
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//    UserModel steve=new UserModel(1,"steve","","IT");
//    UserModel junior=new UserModel(2,"steeve","juni","hjhjh");
//    List<UserModel> mockUsers= Arrays.asList(steve,junior);
//    @Test
//    void getAllUsers() throws Exception {
//
//        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);
//
//        mockMvc.perform(get("/users")
//                .accept(MediaType.APPLICATION_JSON))
//
//                //  test if the status of the call is ok
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value(steve.getName()))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andDo(print());
//
//        //test if the userService was called
//        Mockito.verify(userService, times(1)).getAllUsers();
//    }
//
//    @Test
//    void getOneUser()throws  Exception{
//        Mockito.when(userService.getOneUser(1)).thenReturn(steve);
//
//
//    }
//
//
//
//}