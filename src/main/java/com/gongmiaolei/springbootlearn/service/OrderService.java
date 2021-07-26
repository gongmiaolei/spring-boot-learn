package com.gongmiaolei.springbootlearn.service;

import com.github.pagehelper.PageInfo;
import com.gongmiaolei.springbootlearn.model.request.CreateOrderReq;
import com.gongmiaolei.springbootlearn.model.vo.OrderVO;
import com.gongmiaolei.springbootlearn.model.vo.CartVO;
import com.gongmiaolei.springbootlearn.model.vo.OrderVO;
import java.util.List;

/**
 * 描述：     订单Service
 */
public interface OrderService {


    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    void cancel(String orderNo);

    String qrcode(String orderNo);

    void pay(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    void deliver(String orderNo);

    void finish(String orderNo);
}
