package com.example.chat.Entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


    @Document(value = "Chat_users")
    @Data
    @Builder
    public class Chat {

        @Id
        private String id;
        @Field(name = "User_Name")
        private String name;
        private String message;
        private String receiver;
        private Date date;

    }
