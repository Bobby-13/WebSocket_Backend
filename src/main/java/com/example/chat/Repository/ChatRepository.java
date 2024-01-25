package com.example.chat.Repository;

import com.example.chat.Entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Chat,String> {

}
