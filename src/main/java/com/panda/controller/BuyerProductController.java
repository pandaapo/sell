package com.panda.controller;

import com.panda.dataobject.ProductCategory;
import com.panda.dataobject.ProductInfo;
import com.panda.service.CategoryService;
import com.panda.service.ProductInfoService;
import com.panda.utils.ResultVOUtil;
import com.panda.vo.ProductInfoVO;
import com.panda.vo.ProductVO;
import com.panda.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
//    key="#sellerId"，动态定义key，和参数sellerId值一致；（称为SPEL表达式）
//    condition="#sellerId.length > 3"，该条件成立时，才执行缓存。
//    unless = "#result.getCode() != 0" 返回结果的错误码等于0时，才缓存    ？？？疑问：“result”是固定写法吗？
    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length()>3", unless = "#result.getCode() != 0")
    public ResultVO list(@RequestParam("sellerId") String sellerId){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询类目（一次性查询）(java8，lambda)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType() == productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
