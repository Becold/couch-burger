<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="jumbotron">
    <div class="container">
        <h1>Couch'Burger</h1>
        <p> <spring:message code="welcome.banner" /></p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button"><spring:message code="welcome.more" /></a></p>
    </div>
</div>


<div class="container">
    <h2>Catégories de produit</h2> <!-- TODO Traduction -->
    <div class="row">
        <div class="col-6">
            <c:forEach var="translation" items="${translations}">
                <a href="<spring:url value='/category?id=${translation.category.getCategoryId()}' />">${translation.getContent()}</a><br>
            </c:forEach>
        </div>
    </div>

</div>