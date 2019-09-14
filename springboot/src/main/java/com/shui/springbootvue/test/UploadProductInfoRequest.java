package com.shui.springbootvue.test;


import java.util.List;

/**
 * @description: 无<br>
 * @version: 1.0 <br>
 * @date: 2019/5/29 14:54 <br>
 * @author: leejun <br>
 */
public class UploadProductInfoRequest extends BaseRequest{
    List<BaseProduct> baseProductList;
//    List<BaseCategory> baseCategoryList;

    public List<BaseProduct> getBaseProductList() {
        return baseProductList;
    }

    public void setBaseProductList(List<BaseProduct> baseProductList) {
        this.baseProductList = baseProductList;
    }

//    public List<BaseCategory> getBaseCategoryList() {
//        return baseCategoryList;
//    }
//
//    public void setBaseCategoryList(List<BaseCategory> baseCategoryList) {
//        this.baseCategoryList = baseCategoryList;
//    }
}
