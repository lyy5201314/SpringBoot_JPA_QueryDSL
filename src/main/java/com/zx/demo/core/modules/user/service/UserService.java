package com.zx.demo.core.modules.user.service;

import com.zx.demo.core.modules.user.dto.UserSearchDTO;
import com.zx.demo.core.modules.user.model.User;

import java.util.List;


public interface UserService {

    List<User> search(UserSearchDTO params);

    void save(User user);

    void delete(Long id);

    void update(User user);
}
