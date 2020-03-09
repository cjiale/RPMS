package com.evan.wj.controller;

import com.evan.wj.pojo.Project;
import com.evan.wj.service.ProjectService;

import com.evan.wj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Project> searchResult(@RequestParam("keywords") String keywords){
        //关键词为空查询所有项目
        if("".equals(keywords)){
            return projectService.list();
        }else{
            return projectService.Search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
