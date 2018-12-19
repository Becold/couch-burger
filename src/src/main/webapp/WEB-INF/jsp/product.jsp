<%@ include file="include/importTags.jsp" %>

<!-- TODO Traduction sur cette page -->

<div class="container">
    <h2 class="my-5">${product.getName()}</h2>

    <div class="row">
        <div class="row justify-content-center">
            <div class="card col-8">
                <img class="card-img-top" src="/images/products/${product.category.getCategoryId()}/${product.getProductId()}.png" alt="${product.getName()}">
                <div class="card-body">
                    <c:if test="${product.getIsSparkling() || product.getIsSpicy() || product.getIsSweet()}">
                        <p class="card-text">
                            Ce produit est :
                            <ul>
                                <c:if test="${product.getIsSparkling()}"><li>pétillant</li></c:if>
                                <c:if test="${product.getIsSpicy()}"><li>épicé</li></c:if>
                                <c:if test="${product.getIsSweet()}"><li>sucré</li></c:if>
                            </ul>
                        </p>
                    </c:if>
                    <p class="card-text">
                        Prix : ${product.getFormattedUnitPriceWithVat()}
                    </p>
                    <p class="card-text">
                        Ajouter ce produit au panier :
                        <form:form action="/cart/addProduct"
                                   method="post"
                                   modelAttribute="addProductToCart">
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