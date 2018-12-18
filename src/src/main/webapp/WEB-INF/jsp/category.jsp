<%@ include file="include/importTags.jsp" %>

<div class="container">
    <h2 class="my-5">Nom de la catégorie</h2> <!-- TODO Afficher le nom de la catégorie -->
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-4">
                <div class="card">
                  <img class="card-img-top" src="/images/products/${product.category.getCategoryId()}/${product.getProductId()}.png" alt="Poisson">
                  <div class="card-body">
                    <h3 class="card-title">${product.getName()}</h3>
                    <a href="#" class="btn btn-primary">
                        ${product.getUnitPrice()} €
                        <i class="fa fa-basket"></i>
                    </a>
                  </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>