package com.spring.henallux.templatesSpringProject.dataAccess.util;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.*;
import com.spring.henallux.templatesSpringProject.model.*;
import com.spring.henallux.templatesSpringProject.util.DateProviderConverter;

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

    private ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(product.getProductId());
        productEntity.setName(product.getName());
        productEntity.setUnitPrice(product.getUnitPrice());
        productEntity.setVatRate(product.getVatRate());
        productEntity.setType(product.getType());
        productEntity.setIsSparkling(product.getIsSparkling());
        productEntity.setIsSpicy(product.getIsSpicy());
        productEntity.setIsSweet(product.getIsSweet());

        CategoryEntity category = this.categoryModelToCategoryEntity(product.getCategory());
        productEntity.setCategory(category);

        return productEntity;
    }

    public TranslationCategory translationCategoryEntityToTranslationCategoryModel(TranslationCategoryEntity translationCategoryEntity) {
        TranslationCategory translationCategory = new TranslationCategory();
        translationCategory.setTranslationId(translationCategoryEntity.getTranslationId());
        translationCategory.setLanguage(this.languageEntityToLanguageModel(translationCategoryEntity.getLanguage()));
        translationCategory.setCategory(this.categoryEntityToCategoryModel(translationCategoryEntity.getCategory()));
        translationCategory.setContent(translationCategoryEntity.getContent());
        return translationCategory;
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        Language language = new Language();
        language.setLanguageId(languageEntity.getLanguageId());
        language.setName(languageEntity.getName());
        return language;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setCreationDate(DateProviderConverter.dateToGregorianCalendar(orderEntity.getCreationDate()));
        order.setUser(this.userEntityToUserModel(orderEntity.getUser()));
        order.setPaid(orderEntity.getPaid());
        return order;
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setCreationDate(DateProviderConverter.gregorianCalendarToSqlDate(order.getCreationDate()));
        orderEntity.setUser(this.userModelToUserEntity(order.getUser()));
        orderEntity.setPaid(order.getPaid());
        return orderEntity;
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLineId(orderLineEntity.getOrderLineId());
        orderLine.setOrder(this.orderEntityToOrderModel(orderLineEntity.getOrder()));
        orderLine.setProduct(this.productEntityToProductModel(orderLineEntity.getProduct()));
        orderLine.setQuantity(orderLineEntity.getQuantity());
        orderLine.setUnitPrice(orderLineEntity.getUnitPrice());
        return orderLine;
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderLineId(orderLine.getOrderLineId());
        orderLineEntity.setOrder(this.orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setProduct(this.productModelToProductEntity(orderLine.getProduct()));
        orderLineEntity.setQuantity(orderLine.getQuantity());
        orderLineEntity.setUnitPrice(orderLine.getUnitPrice());
        return orderLineEntity;
    }

    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity) {
        Promotion promotion = new Promotion();
        promotion.setAmountReduction(promotionEntity.getAmountReduction());
        if (promotionEntity.getCategory() != null)
            promotion.setCategory(new ProviderConverter().categoryEntityToCategoryModel(promotionEntity.getCategory()));
        if (promotionEntity.getProduct() != null)
            promotion.setProduct(new ProviderConverter().productEntityToProductModel(promotionEntity.getProduct()));
        promotion.setPromotionId(promotionEntity.getPromotionId());
        promotion.setEndDate(DateProviderConverter.dateToGregorianCalendar(promotionEntity.getEndDate()));
        promotion.setStartDate(DateProviderConverter.dateToGregorianCalendar(promotionEntity.getStartDate()));
        promotion.setTypeChoosenItem(promotionEntity.getTypeChoosenItem());
        promotion.setTypeReduction(promotionEntity.getTypeReduction());
        return promotion;
    }
}
