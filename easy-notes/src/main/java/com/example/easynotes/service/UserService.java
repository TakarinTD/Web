package com.example.easynotes.service;

import com.example.easynotes.model.*;
import org.springframework.stereotype.*;

public interface UserService {
    void saveUser (User user);

    User findOneByUserNameAndStatus (String username, int status);
}
