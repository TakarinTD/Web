package com.example.easynotes.service;

import com.example.easynotes.model.*;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.HashSet;
import java.util.Set;
import org.springframework.transaction.annotation.*;

@Service
public abstract class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional (readOnly = true)
    public UserDetails loadUserByUsername (String userName, int status) {
        User user = userRepository.findOneByUserNameAndStatus(userName, status);
        if (user == null) throw new UsernameNotFoundException(userName);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }

}
