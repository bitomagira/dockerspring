package com.example.demo.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userTest {

    @Test
    void name() {
        User user1 = new User(2);
        assertEquals(2,user1.getId());
    }
}