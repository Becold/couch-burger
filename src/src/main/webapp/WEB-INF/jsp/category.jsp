<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<div class="container">
    <h2 class="my-5">Nom de la catégorie</h2> <!-- TODO Afficher le nom de la catégorie -->
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-4 mb-3">
                <div class="card">
                  <img class="card-img-top" src="/images/products/${product.category.getCategoryId()}/${product.getProductId()}.png" alt="${product.getName()}">
                  <div class="card-body">
                    <h3 class="card-title">
                        <a href="<spring:url value='/product?id=${product.getProductId()}' />">
                            ${product.getName()}
                        </a>
                    </h3>
                    <form:form action="/cart/addProduct"
                               method="post"
                               modelAttribute="productToCart">
                        <form:input type="hidden" path="productId" value="${product.getProductId()}" />
                        <form:input type="hidden" path="quantity" value="1" />
                        <form:button class="btn btn-primary">
                            ${product.getFormattedUnitPriceWithVat()} €
                            <i class="fas fa-shopping-basket"></i>
                        </form:button>
                    </form:form>
                  </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>