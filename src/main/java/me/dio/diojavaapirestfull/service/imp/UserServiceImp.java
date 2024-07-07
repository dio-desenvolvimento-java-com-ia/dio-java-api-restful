package me.dio.diojavaapirestfull.service.imp;

import me.dio.diojavaapirestfull.domain.model.User;
import me.dio.diojavaapirestfull.domain.repository.UserRepositoryI;
import me.dio.diojavaapirestfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepositoryI userRepositoryI;

    @Override
    public User findById(Long id) {
        return userRepositoryI.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepositoryI.existsByAccountNumber(user.getAccount().getNumber()))
            throw new IllegalArgumentException("This account number already exists!");
        return userRepositoryI.save(user);
    }
}
