package com.example.chat.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInfo {
    @Id
    private String email;
    private String phNo;
    private String name;
    private String password;
}
