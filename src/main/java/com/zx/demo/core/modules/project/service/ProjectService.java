package com.zx.demo.core.modules.project.service;

import com.zx.demo.core.modules.project.dto.ProjectSearchDTO;
import com.zx.demo.core.modules.project.model.Project;

import java.util.List;


public interface ProjectService {

    Project getOne(Long id);

    List<Project> findAll();

    List<Project> search(ProjectSearchDTO params);

    List<Project> findByNameAndAddress(String name,String address);
}
