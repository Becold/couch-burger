<%@ include file="include/importTags.jsp" %>

<c:forEach var="product" items="${products}">
    <!-- TODO Afficher les produits dans des cards -->
    ${product.getUnitPrice()} €
</c:forEach>