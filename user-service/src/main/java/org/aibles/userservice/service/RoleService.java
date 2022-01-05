package org.aibles.userservice.service;

import org.aibles.userservice.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getRoles();
    Optional<Role> findById(Long id);
    void  save (Role role);
    void remove(Long id);
    Role findByName(String name);

}
