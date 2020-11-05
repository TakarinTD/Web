package com.example.easynotes.repository;

import com.example.easynotes.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;


@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRole (String role);
}