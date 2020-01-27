package com.example.demo.ticket;

import com.example.demo.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(value= TicketController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TicketControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;


    // know if your mocks are correctly arranged
    @Test
    void testGet() throws Exception{

        assertNotNull(ticketService);
        assertNotNull(mockMvc);
        System.out.println(ticketService);

//        print(ticketService);
    }

    // receive all tickets as a list of json
    // status code 200
    // number of elements
    @Test
    void getAllTickets() throws Exception {
        mockMvc.perform(get("/ticket")
                ).andExpect(status().isOk())
                .andDo(print());
    }

    // receive json from ticket create
    // status code 200
    // number of elements
    @Test
    void createTicket() throws Exception {

        Ticket ticket = new Ticket(1,50,new User(2,"bitomagira","steve junior", "IT"
        ),new User(1,"","",""));

        System.out.println(ticket.toString());

        ObjectMapper obj= new ObjectMapper();
        when(ticketService.createTicket(any(Ticket.class))).thenReturn(ticket);


        mockMvc.perform(post("/ticket")
                .accept(MediaType.APPLICATION_JSON)
                .content(obj.writeValueAsString(ticket))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
        Mockito.verify(ticketService, times(1)).createTicket(ticket);
    }


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



}