package com.example.chat.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserDTO {
    private String email;
    private String phNo;
    private String name;
    private String password;
}
