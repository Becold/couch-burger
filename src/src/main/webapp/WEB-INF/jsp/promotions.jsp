<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<div class="container">
    <h2 class="my-5"><spring:message code="menu.promo" /></h2>

    <div class="row">
        <div class="row justify-content-center">
            <c:forEach var="promotion" items="${promotions}">
            
                <div class="card col-4 mx-1 my-2">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:if test="${promotion.getTypeChoosenItem() eq 'CATEGORY'}">
                                <spring:message code="promo.several" />
                            </c:if>
                            <c:if test="${promotion.getTypeChoosenItem() eq 'PRODUCT'}">
                                <spring:message code="promo.on" /><a href="/product/${promotion.getProduct().getProductId()}">${promotion.getProduct().getName()}</a>
                            </c:if>
                        </h5>
                        <p class="card-text">
                            <c:if test="${promotion.getTypeReduction() eq 'FIXE'}">
                                <spring:message code="promo.of" /> ${promotion.getAmountReduction()}€<br>
                            </c:if>
                            <c:if test="${promotion.getTypeReduction() eq 'POURCENTAGE'}">
                                <spring:message code="promo.of" /> ${promotion.getAmountReduction()}%<br>
                            </c:if>


                            <c:if test="${promotion.getTypeChoosenItem() eq 'CATEGORY'}">
                                <a href="/category/${promotion.getCategory().getCategoryId()}">
                                    <spring:message code="promo.articles" />
                                </a>
                            </c:if>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>