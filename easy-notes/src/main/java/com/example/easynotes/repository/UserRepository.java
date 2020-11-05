package com.example.easynotes.repository;

import com.example.easynotes.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.*;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUserNameAndStatus (String name, int status);

    @Query (value = "select role from user inner join user_role on (user.id = user_role.user_id) inner join role on (user_role.role_id=role.id) where user.id=?1", nativeQuery = true)
    String findUserRole (long userId);

//    @Query (value = "SELECT id, created_at, fullname, password, active, updated_at, username, role_name FROM user ", nativeQuery = true)
//    List<User> findU();

}
