package com.example.chat.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


    @Data
    @Builder
    public class UserDTO {

        private String id;
        private String name;
        private String message;
        private String receiver;
        private Date date;

    }