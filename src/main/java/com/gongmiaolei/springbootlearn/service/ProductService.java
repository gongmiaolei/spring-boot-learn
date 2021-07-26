package com.gongmiaolei.springbootlearn.service;



import com.github.pagehelper.PageInfo;
import com.gongmiaolei.springbootlearn.model.pojo.Product;
import com.gongmiaolei.springbootlearn.model.request.AddProductReq;
import com.gongmiaolei.springbootlearn.model.request.ProductListReq;
import com.gongmiaolei.springbootlearn.model.request.UpdateProductReq;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gml
 * @date 2021/6/19
 **/
public interface ProductService {

    void add(AddProductReq addProductReq);

    void upload(HttpServletRequest httpServletRequest, MultipartFile file);

    String getNewFileName();

    void update(Product product);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);
}
