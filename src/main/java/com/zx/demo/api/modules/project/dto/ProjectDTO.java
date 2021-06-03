package com.zx.demo.api.modules.project.dto;

import com.zx.demo.api.modules.school.dto.SchoolDTO;
import com.zx.demo.api.modules.user.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProjectDTO {

    private String id;
    private String name;
    private String address;
    private List<UserDTO> users;
    private SchoolDTO school;
}
