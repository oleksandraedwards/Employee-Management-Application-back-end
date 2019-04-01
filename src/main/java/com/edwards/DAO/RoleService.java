package com.edwards.DAO;

import com.edwards.model.Role;

import java.util.List;

public interface RoleService {

    Role save(Role role);

    void update(Long id, Role role);

    Role get(long id);

    List<Role> getAll();
}
