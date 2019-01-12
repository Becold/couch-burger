<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<div class="my-3 container">
    <h2><spring:message code="cart.myCart" /></h2>
    <h3 class="mb-5"><spring:message code="cart.youHave" />
        ${cart.size()} <spring:message code="cart.articles" /><c:if test="${cart.size() gt 1}">s</c:if>
    </h3>

    <div class="row justify-content-center">
        <div class="col-8">
            <div class="card card-default">
                <div class="card-header"><spring:message code="cart.cart" /></div>
                <div class="card-body">

                    <c:forEach var="item" items="${cart}">
                        <div class="row d-flex">
                            <div class="col-1">

                                <form:form action="/cart/setProduct"
                                           method="post"
                                           modelAttribute="productToCart">
                                    <form:input type="hidden" path="productId" value="${item.value.getProduct().getProductId()}" />
                                    <form:input type="hidden" path="quantity" value="0" />
                                    <button type="submit" class="btn btn-link btn-xs">
                                        <i class="fas fa-times" style="color: red;"></i>
                                    </button>
                                </form:form>
                            </div>
                            <div class="col-2">
                                <img class="borderburger img-responsive" width="100px" height="auto" src="/images/products/${item.value.getProduct().category.getCategoryId()}/${item.value.getProduct().getProductId()}.png" alt="${item.value.getProduct().getName()}">
                            </div>
                            <div class="col-4">
                                <!-- TODO retirer strong -->
                                <h4 class="product-name"><strong>${item.value.getProduct().getName()}</strong></h4>
                                <h4><small>TVA: ${item.value.getProduct().getVatRate()}%</small></h4>
                            </div>
                            <div class="col text-right">
                                <!-- TODO retirer strong -->
                                <h6><strong>${item.value.getProduct().getFormattedUnitPriceWithVat()} <span class="text-muted">x</span></strong></h6>
                            </div>
                            <div class="col-2">
                                <form:form action="/cart/setProduct"
                                           method="post"
                                           modelAttribute="productToCart">
                                    <form:input type="text" class="form-control input-sm" path="quantity" value="${item.value.getQuantity()}" width="18px" />
                                    <form:input type="hidden" path="productId" value="${item.value.getProduct().getProductId()}" />
                                    <button type="submit" class="btn btn-outline-dark">
                                        <i class="fas fa-sync-alt"></i>
                                    </button>
                                </form:form>
                            </div>
                            <div class="col-1">
                                <form:form action="/cart/addProduct"
                                           method="post"
                                           modelAttribute="productToCart">
                                    <form:input type="hidden" path="productId" value="${item.value.getProduct().getProductId()}" />
                                    <form:input type="hidden" path="quantity" value="1" />
                                    <button type="submit" class="btn btn-outline-dark">
                                        <i class="fas fa-plus"></i>
                                    </button>
                                </form:form>
                                <form:form action="/cart/removeProduct"
                                           method="post"
                                           modelAttribute="productToCart">
                                    <form:input type="hidden" path="productId" value="${item.value.getProduct().getProductId()}" />
                                    <form:input type="hidden" path="quantity" value="1" />
                                    <button type="submit" class="btn btn-outline-dark">
                                        <i class="fas fa-minus"></i>
                                    </button>
                                </form:form>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>

                </div>
                <div class="card-footer">
                    <div class="row text-center">
                        <div class="col-9">
                            <!-- TODO Traduction -->
                            <h4 class="text-right">Vous avez économisé <strong>${totalAmountReduction} €</strong></h4>
                        </div>
                        <div class="col-9">
                            <h4 class="text-right"><spring:message code="cart.total" /> <strong>${totalPrice} €</strong></h4>
                        </div>
                        <div class="col-3">

                            <form:form action="/cart/confirmCart"
                                       method="get">
                                <input type="submit"
                                       class="btn btn-success btn-block"
                                       value="<spring:message code="cart.pay" />"
                                       onclick="return confirm('Etes vous sûr de vouloir passer la commande?');"
                                />
                            </form:form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>