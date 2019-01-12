<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<div class="container">
    <h2 class="my-5">${product.getName()}</h2>

    <div class="row">
        <div class="row justify-content-center">
            <div class="card col-8">
                <img class="borderburger card-img-top" src="/images/products/${product.category.getCategoryId()}/${product.getProductId()}.png" alt="${product.getName()}">
                <div class="card-body">
                    <c:if test="${product.getIsSparkling() || product.getIsSpicy() || product.getIsSweet()}">
                        <p class="card-text">
                                <spring:message code="product.is" />
                            <ul>
                                <c:if test="${product.getIsSparkling()}"><li><spring:message code="product.sparkling" /></li></c:if>
                                <c:if test="${product.getIsSpicy()}"><li><spring:message code="product.spicy" /></li></c:if>
                                <c:if test="${product.getIsSweet()}"><li><spring:message code="product.sweet" /></li></c:if>
                            </ul>
                        </p>
                    </c:if>


                    Des promotions sont appliquées sur ce produit :
                    <ul>
                        -${reductionAmount} €
                    </ul>

                    <p class="card-text">
                        <spring:message code="product.price" /> ${product.getFormattedUnitPriceWithVat()} €
                    </p>
                    <p class="card-text">
                        <spring:message code="product.addToCart" />
                        <form:form action="/cart/addProduct"
                                   method="post"
                                   modelAttribute="productToCart">
                            <form:input type="hidden" path="productId" value="${product.getProductId()}" />
                            <form:input type="text" path="quantity" value="1" />
                            <form:button class="btn btn-primary">
                                <i class="fas fa-shopping-basket"></i>
                            </form:button>
                        </form:form>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>