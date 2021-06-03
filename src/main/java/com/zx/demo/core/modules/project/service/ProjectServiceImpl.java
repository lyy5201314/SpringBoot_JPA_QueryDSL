package com.zx.demo.core.modules.project.service;

import com.zx.demo.base.common.list.ListUtil;
import com.zx.demo.core.modules.project.dto.ProjectSearchDTO;
import com.zx.demo.core.modules.project.model.Project;
import com.zx.demo.core.modules.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project getOne(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()){
            return projectOptional.get();
        }
        return null;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> search(ProjectSearchDTO params) {
        Iterable<Project> all = projectRepository.findAll(params.toPredicate());
        return ListUtil.copyIterator(all.iterator());
    }

    @Override
    public List<Project> findByNameAndAddress(String name, String address) {
        return projectRepository.findByNameAndAddress(name,address);
    }
}
