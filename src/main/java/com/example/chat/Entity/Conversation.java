package com.example.chat.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = UserInfo.class)
    @JoinColumn(name = "user1")
    private UserInfo user1;

    @ManyToOne
    @JoinColumn(name = "user2")
    private UserInfo user2;
}
