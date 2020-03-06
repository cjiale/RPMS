package com.evan.wj.service;

import com.evan.wj.dao.ProjectDAO;
import com.evan.wj.pojo.Project;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    CategoryService categoryService;

    public List<Project> list(){
        Sort sort= new Sort(Sort.Direction.DESC,"id");
        return projectDAO.findAll(sort);
    }

    public void addOrUpdate(Project project){
        projectDAO.save(project);
    }

    public void deleteById(int id){
        projectDAO.deleteById(id);
    }

    public List<Project> ListByCategory(int cid){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return projectDAO.findAllByCategory(category);
    }
}
