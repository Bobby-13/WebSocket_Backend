package com.example.chat.Controller;

import com.example.chat.DTO.UserDTO;
import com.example.chat.Entity.Chat;
import com.example.chat.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class Chatcontroller {

    @Autowired
    private ChatService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String Createuser(@RequestBody UserDTO userDTO){
    return service.CreateChat(userDTO);
    }

    @GetMapping("getall")
    public List<Chat> GetUser(){
        return  service.GetEmployee();
    }

}
