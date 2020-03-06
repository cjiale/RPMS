package com.evan.wj.controller;

import com.evan.wj.pojo.Project;
import com.evan.wj.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/api/projects")
    public List<Project> list() throws  Exception{
        return projectService.list();
    }

    @PostMapping("/api/projects")
    public Project addOrUpdate(@RequestBody Project project) throws Exception{
        projectService.addOrUpdate(project);
        return project;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Project project) throws Exception{
        projectService.deleteById(project.getId());
    }

    @GetMapping("/api/categories/{cid}/projects")
    public List<Project> listByCategory(@PathVariable("cid") int cid) throws  Exception{
        if (0 != cid){
            return projectService.listByCategory(cid);
        }else{
            return list();
        }
    }
}
