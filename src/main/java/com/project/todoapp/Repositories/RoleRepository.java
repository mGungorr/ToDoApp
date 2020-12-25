package com.project.todoapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.todoapp.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}