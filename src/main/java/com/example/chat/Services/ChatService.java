package com.example.chat.Services;

import com.example.chat.DTO.UserDTO;
import com.example.chat.Entity.Chat;
import com.example.chat.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public String CreateChat(UserDTO userDTO){
        try{
            Chat chat=Chat.builder().id(userDTO.getId())
                    .name(userDTO.getName())
                    .date(new Date())
                    .message(userDTO.getMessage())
                    .receiver(userDTO.getReceiver())
                    .build();

            chatRepository.save(chat);
        }
        catch (Exception e){

        }
        return "USer Added";
    }


    public List<Chat> GetEmployee(){
        return chatRepository.findAll();
    }
}
