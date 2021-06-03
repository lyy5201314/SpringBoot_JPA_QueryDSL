package com.zx.demo.core.modules.user.service;

import com.zx.demo.base.common.list.ListUtil;
import com.zx.demo.core.modules.user.dto.UserSearchDTO;
import com.zx.demo.core.modules.user.model.User;
import com.zx.demo.core.modules.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public List<User> search(UserSearchDTO params) {
        Iterable<User> all = userRepository.findAll(params.toPredicate());
        return ListUtil.copyIterator(all.iterator());
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        User oldUser = userRepository.findById(user.getId()).get();
        modelMapper.map(user, oldUser);
        userRepository.save(oldUser);
    }
}
