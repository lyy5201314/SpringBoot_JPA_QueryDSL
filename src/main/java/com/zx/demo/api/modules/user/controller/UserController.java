package com.zx.demo.api.modules.user.controller;

import com.zx.demo.api.modules.user.dto.UserDTO;
import com.zx.demo.base.api.constants.ApiRouteConstants;
import com.zx.demo.base.api.controller.BaseApiController;
import com.zx.demo.core.modules.user.dto.UserSearchDTO;
import com.zx.demo.core.modules.user.model.User;
import com.zx.demo.core.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseApiController<User> {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> search(UserSearchDTO params){
        List<User> users = userService.search(params);
        List<UserDTO> userDTOS = users.stream().map(e -> modelMapper.map(e, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOS;
    }

    @PostMapping
    public void save(@RequestBody UserDTO userDTO) {
        User user = toModel(userDTO, User.class);
        userService.save(user);
    }

    @DeleteMapping(value = ApiRouteConstants.PATH_ID)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value = ApiRouteConstants.PATH_ID)
    public void update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
        User user = toModel(userDTO, User.class);
        user.setId(id);
        userService.update(user);
    }
}
