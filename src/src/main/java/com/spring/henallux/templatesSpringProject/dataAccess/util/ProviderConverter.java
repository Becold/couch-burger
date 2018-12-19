package com.spring.henallux.templatesSpringProject.dataAccess.util;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.*;
import com.spring.henallux.templatesSpringProject.model.*;

public class ProviderConverter {

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(category.getCategoryId());
        return categoryEntity;
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setCategoryId(categoryEntity.getCategoryId());
        return category;
    }

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setAuthorities(user.getAuthorities());
        userEntity.setAccountNonExpired(user.getAccountNonExpired());
        userEntity.setAccountNonLocked(user.getAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.getCredentialsNonExpired());
        userEntity.setEnabled(user.getEnabled());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setName(user.getName());
        userEntity.setAddressStreetName(user.getAddressStreetName());
        userEntity.setAddressNumber(user.getAddressNumber());
        userEntity.setAddressBox(user.getAddressBox());
        userEntity.setAddressLocality(user.getAddressLocality());
        userEntity.setAddressPostalCode(user.getAddressPostalCode());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setSexe(user.getSexe());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
        user.setUserId(userEntity.getUserId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setName(userEntity.getName());
        user.setAddressStreetName(userEntity.getAddressStreetName());
        user.setAddressNumber(userEntity.getAddressNumber());
        user.setAddressBox(userEntity.getAddressBox());
        user.setAddressLocality(userEntity.getAddressLocality());
        user.setAddressPostalCode(userEntity.getAddressPostalCode());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        user.setSexe(userEntity.getSexe());
        return user;
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setProductId(productEntity.getProductId());
        product.setName(productEntity.getName());
        product.setUnitPrice(productEntity.getUnitPrice());
        product.setVatRate(productEntity.getVatRate());
        product.setType(productEntity.getType());
        product.setIsSparkling(productEntity.getIsSparkling());
        product.setIsSpicy(productEntity.getIsSpicy());
        product.setIsSweet(productEntity.getIsSweet());

        Category category = this.categoryEntityToCategoryModel(productEntity.getCategory());
        product.setCategory(category);

        return product;
    }

    public TranslationCategory translationCategoryEntityToTranslationCategoryModel(TranslationCategoryEntity translationCategoryEntity) {
        TranslationCategory translationCategory = new TranslationCategory();
        translationCategory.setTranslationId(translationCategoryEntity.getTranslationId());
        translationCategory.setLanguage(this.languageEntityToLanguageModel(translationCategoryEntity.getLanguage()));
        translationCategory.setCategory(this.categoryEntityToCategoryModel(translationCategoryEntity.getCategory()));
        translationCategory.setContent(translationCategoryEntity.getContent());
        return translationCategory;
    }

    private Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        Language language = new Language();
        language.setLanguageId(languageEntity.getLanguageId());
        language.setName(languageEntity.getName());
        return language;
    }
}
