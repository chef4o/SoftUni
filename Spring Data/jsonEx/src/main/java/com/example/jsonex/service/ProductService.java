package com.example.jsonex.service;

import com.example.jsonex.model.dto.ProductPriceSellerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;
    List<ProductPriceSellerDto> findAllProductsInRangeOrderByPrice(BigDecimal valueOf, BigDecimal valueOf1);
}
