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
    <h2 class="mb-2"><spring:message code="welcome.categories" /></h2> <!-- TODO Traduction -->
    <div class="row">
        <c:forEach var="translation" items="${translations}">
            <div class="col-md-3 mb-3">
                <a href="<spring:url value='/category/${translation.category.getCategoryId()}' />">
                    <div class="card">
                        <img class="card-img-top" src="/images/categories/${translation.category.getCategoryId()}.png" alt="${translation.getContent()}">
                        <div class="card-body">
                            <h4 class="card-title">
                                ${translation.getContent()}
                            </h4>
                        </div>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

</div>