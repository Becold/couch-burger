package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findByCategoryCategoryId(Integer categoryId);
}
