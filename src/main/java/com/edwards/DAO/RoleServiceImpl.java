package com.edwards.DAO;

import com.edwards.model.Role;
import com.edwards.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void update(Long id, Role role) {

    }
    @Override
    public Role get(long id) {
        return roleRepository.getOne(id);

    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
