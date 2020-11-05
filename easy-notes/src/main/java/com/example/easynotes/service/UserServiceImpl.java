package com.example.easynotes.service;

import com.example.easynotes.model.*;
import com.example.easynotes.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findOneByUserNameAndStatus (String username, int status) {
        return userRepository.findOneByUserNameAndStatus(username, status);
    }

    @Override
    public void saveUser (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        Role userRole = roleRepository.findByRole("user");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setRoleName(userRole.getRole());
        userRepository.save(user);
    }
}

