package com.gongmiaolei.springbootlearn.service;

import com.gongmiaolei.springbootlearn.exception.ImoocMallException;
import com.gongmiaolei.springbootlearn.model.pojo.User;

/**
 * @author gml
 * @date 2021/6/17
 **/
public interface UserService {
    User getUser();

    void register(String userName, String password) throws ImoocMallException;

    User login(String userName, String password) throws ImoocMallException;

    void updateInformation(User user) throws ImoocMallException;

    boolean checkAdminRole(User user);
}
