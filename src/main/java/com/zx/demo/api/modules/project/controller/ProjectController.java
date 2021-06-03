package com.zx.demo.api.modules.project.controller;

import com.zx.demo.api.modules.project.dto.ProjectDTO;
import com.zx.demo.base.api.constants.ApiRouteConstants;
import com.zx.demo.base.api.controller.BaseApiController;
import com.zx.demo.core.modules.project.dto.ProjectSearchDTO;
import com.zx.demo.core.modules.project.model.Project;
import com.zx.demo.core.modules.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/project")
public class ProjectController extends BaseApiController<Project> {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = ApiRouteConstants.PATH_ID)
    public ProjectDTO getOne(@PathVariable Long id) {
        Project project = projectService.getOne(id);
        if (project!=null){
            return toDTO(project, ProjectDTO.class);
        }
        return null;
    }

    @GetMapping
    public List<ProjectDTO> search(ProjectSearchDTO params){
        List<Project> projects = projectService.search(params);
        List<ProjectDTO> ProjectDTOs = projects.stream().map(e -> modelMapper.map(e, ProjectDTO.class)).collect(Collectors.toList());
        return ProjectDTOs;
    }

    @GetMapping(value = "/findAll")
    public List<ProjectDTO> findAll(){
        List<Project> projects = projectService.findAll();
        List<ProjectDTO> ProjectDTOs = projects.stream().map(e -> modelMapper.map(e, ProjectDTO.class)).collect(Collectors.toList());
        return ProjectDTOs;
    }

    @GetMapping(value = "/findByNameAndAddress")
    public List<ProjectDTO> findByNameAndAddress(String name,String address){
        List<Project> projects = projectService.findByNameAndAddress(name, address);
        List<ProjectDTO> projectDTOs = projects.stream().map(e -> modelMapper.map(e, ProjectDTO.class)).collect(Collectors.toList());
        return projectDTOs;
    }
}
