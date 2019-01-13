<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<div class="container">
    <!-- TODO Traductions -->
    <h2 class="my-5">Promotions</h2>

    <div class="row">
        <div class="row justify-content-center">
            <c:forEach var="promotion" items="${promotions}">
            
                <div class="card col-4 mx-1 my-2">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:if test="${promotion.getTypeChoosenItem() eq 'CATEGORY'}">
                                Réduction sur plusieurs articles
                            </c:if>
                            <c:if test="${promotion.getTypeChoosenItem() eq 'PRODUCT'}">
                                Réduction sur les <a href="/product/${promotion.getProduct().getProductId()}">${promotion.getProduct().getName()}</a>
                            </c:if>
                        </h5>
                        <p class="card-text">
                            <c:if test="${promotion.getTypeReduction() eq 'FIXE'}">
                                Réduction de ${promotion.getAmountReduction()}€<br>
                            </c:if>
                            <c:if test="${promotion.getTypeReduction() eq 'POURCENTAGE'}">
                                Réduction de -${promotion.getAmountReduction()}%<br>
                            </c:if>


                            <c:if test="${promotion.getTypeChoosenItem() eq 'CATEGORY'}">
                                <a href="/category/${promotion.getCategory().getCategoryId()}">
                                    Voir les articles en promotion
                                </a>
                            </c:if>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>