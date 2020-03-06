package com.evan.wj.dao;

import com.evan.wj.pojo.Project;
import com.evan.wj.pojo.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project,Integer>{
    List<Project> findAllByCategory(Category category);
    List<Project> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
}
