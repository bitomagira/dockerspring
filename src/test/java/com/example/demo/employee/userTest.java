package com.example.demo.employee;

import com.example.demo.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userTest {

    @Test
    void name() {
        User user1 = new User(2,"steve","junior","it");
        assertEquals(2,user1.getId());
    }
}