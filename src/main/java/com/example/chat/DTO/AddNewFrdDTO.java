package com.example.chat.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddNewFrdDTO {

    private String currentUser;
    private String newFriend;
}
