package com.example.final_titv.repository;

import com.example.final_titv.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role getByNameIgnoreCase(String name);
}
