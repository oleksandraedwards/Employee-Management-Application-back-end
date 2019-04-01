package com.edwards.DAO;

import com.edwards.model.User;

import java.util.List;

public interface UserService {

    // save
    User save(User user);

    // get a single record
    User get(long id);

    // get all the record
    List<User> getAll();

    // update the record:
    void update(Long id, User user);

    // delete:
    void delete(User user);

}

