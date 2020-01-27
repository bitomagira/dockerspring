package com.example.demo.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=ex.class)
class exTest {
    @Autowired
    private MockMvc mockmvc;
    @MockBean
    private exservice exservice;

    @Test
    void testerr () throws Exception{

        when(exservice.say()).thenReturn("hello");
        mockmvc.perform(get("/ex"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("hello"))
                .andDo(print());
    }

}