package com.gongmiaolei.springbootlearn.service;

import com.github.pagehelper.PageInfo;
import com.gongmiaolei.springbootlearn.model.pojo.Category;
import com.gongmiaolei.springbootlearn.model.request.AddCategoryReq;
import com.gongmiaolei.springbootlearn.model.vo.CategoryVO;

import java.util.List;

/**
 * @author gml
 * @date 2021/6/19
 **/
public interface CategoryService {

    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer integer);
}
