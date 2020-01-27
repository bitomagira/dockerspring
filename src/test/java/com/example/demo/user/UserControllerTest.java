package com.example.demo.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import org.junit.runner.RunWith;
@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    User steve=new User(1,"steve","","IT");
    User junior=new User(2,"steeve","juni","hjhjh");
    List<User> mockUsers= Arrays.asList(steve,junior);


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }}

    @Test
    void getAllUsers() throws Exception {

        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON))

                //  test if the status of the call is ok
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(steve.getName()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());

        //test if the userService was called
        Mockito.verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getOneUser()throws  Exception{
        Mockito.when(userService.getOneUser(1)).thenReturn(steve);
        mockMvc.perform(get("/users/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(steve))
                .andDo(print());
    }

    @Test
    void createTicket() throws Exception {

        User user = new User(1, "steve", "junior", "IT");
        when(userService.postUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andDo(print());

        verify(userService, times(1)).postUser(user);
    }



}