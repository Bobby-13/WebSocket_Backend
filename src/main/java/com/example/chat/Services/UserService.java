package com.example.chat.Services;

import com.example.chat.DTO.AddNewFrdDTO;
import com.example.chat.DTO.LoginUserDTO;
import com.example.chat.DTO.NewUserDTO;
import com.example.chat.Entity.Conversation;
import com.example.chat.Entity.UserInfo;
import com.example.chat.Repository.ConversationRepository;
import com.example.chat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public String AddNewuser(NewUserDTO newUserDTO){

        UserInfo userInfo = UserInfo.builder()
                .email(newUserDTO.getEmail())
                .phNo(newUserDTO.getPhNo())
                .name(newUserDTO.getName())
                .password(newUserDTO.getPassword())
                .build();
        userRepository.save(userInfo);
        return "User added Successfully";
    }


    public String UserLogin(LoginUserDTO loginUserDTO) {

        Optional<UserInfo> userInfo = userRepository.findById(loginUserDTO.getUsername());

        if(userInfo.isPresent()){
           if(userInfo.get().getPassword().equals(loginUserDTO.getPassword())){
               return "User Found";
           }
           else
           {
               return "Invalid Password";
           }
        }
        else{
            return "No user Found";
        }
    }

    public String AddNewFriend(AddNewFrdDTO addNewFrdDTO) {

         Optional<UserInfo> user1 = userRepository.findById(addNewFrdDTO.getCurrentUser());
         Optional<UserInfo> user2 = userRepository.findById(addNewFrdDTO.getNewFriend());

         UserInfo userInfo1 = null;
         UserInfo userInfo2 = null;
         if(user1.isPresent()){
             userInfo1 = UserInfo.builder()
                     .email(user1.get().getEmail())
                     .phNo(user1.get().getPhNo())
                     .name(user1.get().getName())
                     .password(user1.get().getPassword())
                     .build();
         }

         if(user2.isPresent()){
             userInfo2 = UserInfo.builder()
                     .email(user2.get().getEmail())
                     .phNo(user2.get().getPhNo())
                     .name(user2.get().getName())
                     .password(user2.get().getPassword())
                     .build();
         }


        Conversation conversation = Conversation.builder()
                .user1(userInfo1)
                .user2(userInfo2)
                .build();
         conversationRepository.save(conversation);

         return "New Friend Added";
    }
}
