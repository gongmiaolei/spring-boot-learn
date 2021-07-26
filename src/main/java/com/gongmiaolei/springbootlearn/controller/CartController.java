package com.gongmiaolei.springbootlearn.controller;

import com.gongmiaolei.springbootlearn.common.ApiRestResponse;
import com.gongmiaolei.springbootlearn.filter.UserFilter;
import com.gongmiaolei.springbootlearn.model.vo.CartVO;
import com.gongmiaolei.springbootlearn.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gml
 * @date 2021/6/20
 **/
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/list")
    @ApiOperation("购物车列表")
    public ApiRestResponse list(){
        List<CartVO> cartList = cartService.list(UserFilter.currentUser.getId());
        return ApiRestResponse.success(cartList);
    }

    @PostMapping("/add")
    @ApiOperation("添加商品到购物车")
    public ApiRestResponse add(@RequestParam Integer productId,@RequestParam Integer count){
        Integer id = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.add(id, productId, count);
        return ApiRestResponse.success();
    }

    @PostMapping("/update")
    @ApiOperation("更新购物车")
    public ApiRestResponse update(@RequestParam Integer productId,@RequestParam Integer count){
        Integer id = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.update(id, productId, count);
        return ApiRestResponse.success();
    }

    @PostMapping("/delete")
    @ApiOperation("删除购物车")
    public ApiRestResponse delete(@RequestParam Integer productId){
        Integer id = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.delete(id, productId);
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("/select")
    @ApiOperation("选择/不选择购物车的某商品")
    public ApiRestResponse select(@RequestParam Integer productId,@RequestParam Integer selected){
        Integer id = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.selectOrNot(UserFilter.currentUser.getId(),productId,selected);
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("/selectAll")
    @ApiOperation("全选择/全不选择购物车的某商品")
    public ApiRestResponse selectAll(@RequestParam Integer selected){
        Integer id = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.selectAllOrNot(id,selected);
        return ApiRestResponse.success(cartVOList);
    }
}
