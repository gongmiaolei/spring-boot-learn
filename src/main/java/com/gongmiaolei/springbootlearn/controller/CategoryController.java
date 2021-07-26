package com.gongmiaolei.springbootlearn.controller;
import com.github.pagehelper.PageInfo;
import com.gongmiaolei.springbootlearn.common.ApiRestResponse;
import com.gongmiaolei.springbootlearn.common.Constant;
import com.gongmiaolei.springbootlearn.exception.ImoocMallExceptionEnum;
import com.gongmiaolei.springbootlearn.model.pojo.Category;
import com.gongmiaolei.springbootlearn.model.request.AddCategoryReq;
import com.gongmiaolei.springbootlearn.model.pojo.User;
import com.gongmiaolei.springbootlearn.model.request.UpdateCategoryReq;
import com.gongmiaolei.springbootlearn.model.vo.CategoryVO;
import com.gongmiaolei.springbootlearn.service.CategoryService;
import com.gongmiaolei.springbootlearn.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author gml
 * @date 2021/6/19  目录Controller
 **/
@Controller
public class CategoryController {
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session, @RequestBody @Valid AddCategoryReq addCategoryReq) {

        User currentUser = (User) session.getAttribute(Constant.IMOOC_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_LOGIN);
        }
        if (userService.checkAdminRole(currentUser)) {
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();
        } else {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_ADMIN);
        }
    }

    @ApiOperation("后台更新目录")
    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(@RequestBody @Valid UpdateCategoryReq updateCategoryReq, HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.IMOOC_MALL_USER);

        if (currentUser == null) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_LOGIN);
        }

        if (userService.checkAdminRole(currentUser)) {
            Category category = new Category();
            BeanUtils.copyProperties(updateCategoryReq, category);
            categoryService.update(category);
            return ApiRestResponse.success();
        } else {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_ADMIN);
        }
    }

    @ApiOperation("后台删除目录")
    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @GetMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping("/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOS);
    }
}
