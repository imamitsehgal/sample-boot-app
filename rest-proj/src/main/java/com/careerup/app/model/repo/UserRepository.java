package com.careerup.app.model.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.careerup.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
