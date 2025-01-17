package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO {

    private ProductRepository productRepository;

    @Autowired
    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ArrayList<Product> findByCategoryId(Integer categoryId) {
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<ProductEntity> productsEntity = this.productRepository.findByCategoryCategoryId(categoryId);
        for (ProductEntity productEntity : productsEntity) {
            products.add(new ProviderConverter().productEntityToProductModel(productEntity));
        }
        return products;
    }

    public Product findOne(Integer productId) throws ProductNotFoundException {
        ProductEntity productEntity = productRepository.findOne(productId);
        if (productEntity == null) {
            throw new ProductNotFoundException();
        }
        return new ProviderConverter().productEntityToProductModel(productEntity);
    }
}
