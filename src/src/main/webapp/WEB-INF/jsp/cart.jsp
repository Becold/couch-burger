<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<!-- TODO Traduction sur toute cette page -->

<div class="container">
    <h2 class="mt-5">Mon panier</h2>
    <h3 class="mb-5">Vous avez ${cart.size()} article<c:if test="${cart.size()}>1">s</c:if></h3>

    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card card-default">
                <div class="card-header">Panier</div>
                <div class="card-body">

                    <c:forEach var="item" items="${cart}">
                        <div class="row d-flex">
                            <div class="col-md-1">
                                <button type="button" class="btn btn-link btn-xs">
                                    <i class="fas fa-times" style="color: red;"></i>
                                </button>
                            </div>
                            <div class="col-md-2">
                                <img class="img-responsive" width="100px" height="auto" src="/images/products/${item.value.getProduct().category.getCategoryId()}/${item.value.getProduct().getProductId()}.png" alt="${item.value.getProduct().getName()}">
                            </div>
                            <div class="col-md-4">
                                <h4 class="product-name"><strong>${item.value.getProduct().getName()}</strong></h4>
                                <h4><small>TVA: ${item.value.getProduct().getVatRate()}%</small></h4>
                            </div>
                            <div class="col text-right">
                                <h6><strong>${item.value.getProduct().getFormattedUnitPriceWithVat()} <span class="text-muted">x</span></strong></h6>
                            </div>
                            <div class="col-md-2">
                                <input type="text" class="form-control input-sm" value="${item.value.getQuantity()}">
                            </div>
                            <div class="col-md-1">
                                <i class="fas fa-plus"></i>
                                <i class="fas fa-minus"></i>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>


                    <div class="row">
                        <div class="col-md-9">
                            <h6 class="text-right">Vous avez modifié votre panier?</h6>
                        </div>
                        <div class="col-md-3">
                            <button type="button" class="btn btn-default btn-sm btn-block">
                                Mettre à jour
                            </button>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="row text-center">
                        <div class="col-md-9">
                            <h4 class="text-right">Total <strong>${totalPrice} €</strong></h4>
                        </div>
                        <div class="col-md-3">
                            <form:form action="/cart/confirmCart"
                                       method="post">
                                <input type="submit" class="btn btn-success btn-block" value="Passer à la caisse" />
                            </form:form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>