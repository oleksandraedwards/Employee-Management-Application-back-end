package com.edwards.DAO;

import com.edwards.model.User;
import com.edwards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void update(Long id, User user) {
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }
}
