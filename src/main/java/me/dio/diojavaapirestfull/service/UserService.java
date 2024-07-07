package me.dio.diojavaapirestfull.service;

import me.dio.diojavaapirestfull.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

}
