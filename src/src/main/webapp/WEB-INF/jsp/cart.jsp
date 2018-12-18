<%@ include file="include/importTags.jsp" %>


<div class="container">
    <h2 class="my-5">Mon panier <span>Vous avez ${cart.size()} article(s)</span></h2>
    <c:forEach var="item" items="${cart}">
        ${item.value.getQuantity()} x ${item.value.getProduct().getName()}<br>
        <!-- TODO Afficher les produits dans des cards -->
    </c:forEach>

    <form:form action="/cart/confirmCart"
               method="post">
        <input type="submit" class="btn btn-primary" value="Valider ma commande" />
    </form:form>
</div>