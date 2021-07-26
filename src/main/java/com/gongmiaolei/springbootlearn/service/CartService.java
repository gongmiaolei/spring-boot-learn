package com.gongmiaolei.springbootlearn.service;

import com.gongmiaolei.springbootlearn.model.vo.CartVO;

import java.util.List;

/**
 * @author gml
 * @date 2021/6/20
 **/
public interface CartService {

    List<CartVO> list(Integer userID);

    List<CartVO> add(Integer userId, Integer productId, Integer count);

    List<CartVO> update(Integer userId, Integer productId, Integer count);

    List<CartVO> delete(Integer userId, Integer productId);

    List<CartVO> selectOrNot(Integer userId, Integer productId, Integer selected);

    List<CartVO> selectAllOrNot(Integer userId, Integer selected);
}
