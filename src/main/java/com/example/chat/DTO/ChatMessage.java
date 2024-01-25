package com.example.chat.DTO;

import com.example.chat.Entity.Enum.MessageType;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
//    private String phNo;
    private String message;
    private String senderName;
    private String receiverName;
    private String date;
    private MessageType status;
}
