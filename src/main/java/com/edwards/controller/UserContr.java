package com.edwards.controller;

import java.lang.RuntimeException;


import com.edwards.DAO.RoleServiceImpl;
import com.edwards.DAO.UserServiceImpl;
import com.edwards.model.Role;
import com.edwards.model.User;
import com.edwards.repository.RoleRepository;
import com.edwards.repository.UserRepository;
import com.edwards.security.jwt.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserContr extends RuntimeException {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImpl roleServiceImpl;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("admin")
    public List<User> getAllUsers() {
        return userServiceImpl.getAll();
    }


    @GetMapping("admin/roles")
    public List<Role> getAllRoles() {
        return roleServiceImpl.getAll();
    }

    /////////////////////////////////////////////////
//    findByID(@PathVariable(value = "id") Long id)
////            throws ResourceNotFoundException {
////        Empl empl = emplRep.findById()
////                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//    {
//        {
//            User user = userServiceImpl.get(id);
//
//            if (user == null) {
//                return ResponseEntity.notFound().build();
//            }
//
//            return ResponseEntity.ok().body(user);
//        }
//    }
//
//
//    /////////////////////////////////////////////////
//    // DELETE USER
    @DeleteMapping("admin/{id}")
    public ResponseEntity<User>
    delete(@PathVariable(value = "id") Long id) {

        User user = userServiceImpl.get(id);
        LOG.info("Employee id to delete ");


        try {
            LOG.info("Employee id to delete " + id);
        } catch (EntityNotFoundException rx) {
            LOG.error(rx.getMessage(), rx);
        }
        if (user == null) {
            LOG.info("not found");
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        LOG.info("try to delete");
        return ResponseEntity.ok().body(user);

    }



    /////////////////////////////////////////////////
    // FIND BY ID
    @GetMapping("admin/{id}")
    public ResponseEntity<User>
    findByID(@PathVariable(value = "id") Long id)
//            throws ResourceNotFoundException {
//        Empl empl = emplRep.findById()
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    {
        {
            User user = userServiceImpl.get(id);

            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(user);
        }
    }
}