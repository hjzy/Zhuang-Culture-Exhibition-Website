package com.train.gdmt.user.service;

import com.train.gdmt.user.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User login(String username);
}
