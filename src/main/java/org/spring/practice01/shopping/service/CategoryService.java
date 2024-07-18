package org.spring.practice01.shopping.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final SqlSession SESSION;
    private final String NAMESPACE="org.spring.practice01.mappers.CategoryMapper";

    public CategoryDTO pickCategoryName(int id){
        return SESSION.selectOne(NAMESPACE+".pickCategoryName",id);
    }
}

