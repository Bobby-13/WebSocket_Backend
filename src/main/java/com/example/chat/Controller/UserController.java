package com.example.chat.Controller;

import com.example.chat.DTO.AddNewFrdDTO;
import com.example.chat.DTO.ChatMessage;
import com.example.chat.DTO.LoginUserDTO;
import com.example.chat.DTO.NewUserDTO;
import com.example.chat.Entity.UserInfo;
import com.example.chat.Repository.UserRepository;
import com.example.chat.Services.ChatService;
import com.example.chat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping
@CrossOrigin
public class UserController {
 @Autowired
 private UserRepository repo;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public String AddUser(@RequestBody NewUserDTO newUserDTO)
    {
        System.out.println("User "+ newUserDTO);
        return  userService.AddNewuser(newUserDTO);
    }


    @PostMapping("/userLogin")
    public String UserLogin(@RequestBody LoginUserDTO loginUserDTO){
        return userService.UserLogin(loginUserDTO);
    }

    @PostMapping("/newFriend")
    public String NewFriend(@RequestBody AddNewFrdDTO addNewFrdDTO){
        return userService.AddNewFriend(addNewFrdDTO);
    }


    @GetMapping("/users")
    public List<UserInfo> Allusers(){
        return repo.findAll();
    }





















    @MessageMapping("/message")
    @SendTo("/chatRoom/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println("Response"+chatMessage);
        return chatMessage;
    }
    @MessageMapping("/private-message")
    public ChatMessage recMessage(@Payload ChatMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
//       chatServices.AddChat(message);
        System.out.println(message.toString());
        return message;
    }

}
