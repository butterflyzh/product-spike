package com.butterfly.productspike.util;

import com.butterfly.productspike.bean.Product;
import com.butterfly.productspike.vo.ProductVo;

public class PackageProduct {

    public static ProductVo packageProductVo(Product product){
        if (product == null){
            return null;
        }
        ProductVo productVo = new ProductVo();
        productVo.setId(product.getId());
        productVo.setProductName(product.getProductName());
        productVo.setProductPrice(product.getProductPrice().toString());
        productVo.setProductAmount(product.getProductAmount());
        productVo.setStartTime(product.getStartTime().toString());
        productVo.setEndTime(product.getEndTime().toString());
        return productVo;
    }

    private static Product packageProduct(ProductVo productVo){

        return null;
    }
}
