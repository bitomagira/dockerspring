package com.example.demo.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ex")
public class ex {

    @Autowired
    private exservice myserv;

    @RequestMapping()
    public String extest(){
        return myserv.say();
    }
}
