<%@ include file="include/importTags.jsp" %>

<div class="card card-default">
    <div class="card-header">Inscription</div>

    <spring:hasBindErrors name="userRegister">
        <c:forEach var="error" items="${errors.allErrors}">
            <b><spring:message message="${error}" /></b>
            <br/>
        </c:forEach>
    </spring:hasBindErrors>

    <div class="card-body">
        <form:form
                method="POST"
                action=""
                modelAttribute="userRegister">
            <div class="form-group row">
                <form:label path="username" class="col-sm-4 col-form-label text-md-right">Pseudonyme</form:label>
                <div class="col-md-6">
                    <form:input id="username" type="text" class="form-control" path="username" />
                </div>
            </div>

            <div class="form-group row">
                <form:label path="email" class="col-sm-4 col-form-label text-md-right">Adresse e-mail</form:label>
                <div class="col-md-6">
                    <form:input id="email" type="email" class="form-control" path="email" />
                </div>
            </div>

            <div class="form-group row">
                <label path="password" class="col-md-4 col-form-label text-md-right">Mot-de-passe</label>
                <div class="col-md-6">
                    <form:input id="password" type="password" class="form-control" path="password" />
                </div>
            </div>

            <div class="form-group row">
                <label path="confirmPassword" class="col-md-4 col-form-label text-md-right">Confirmer le mot-de-passe</label>
                <div class="col-md-6">
                    <form:input id="confirmPassword" type="password" class="form-control" path="confirmPassword" />
                </div>
            </div>

            <hr>

            <div class="form-group row">
                <label path="firstname" class="col-md-4 col-form-label text-md-right">Prénom</label>
                <div class="col-md-6">
                    <form:input id="firstname" type="text" class="form-control" path="firstname" />
                </div>
            </div>

            <div class="form-group row">
                <label path="name" class="col-md-4 col-form-label text-md-right">Nom de famille</label>
                <div class="col-md-6">
                    <form:input id="name" type="text" class="form-control" path="name" />
                </div>
            </div>

            <hr>

            <div class="form-group row">
                <label path="addressStreetName" class="col-md-4 col-form-label text-md-right">Rue</label>
                <div class="col-md-6">
                    <form:input id="addressStreetName" type="text" class="form-control" path="addressStreetName" />
                </div>
            </div>

            <div class="form-group row">
                <label path="addressNumber" class="col-md-4 col-form-label text-md-right">Numéro de rue</label>
                <div class="col-md-6">
                    <form:input id="addressNumber" type="text" class="form-control" path="addressNumber" />
                </div>
            </div>

            <div class="form-group row">
                <label path="addressBox" class="col-md-4 col-form-label text-md-right">Boite (optionel)</label>
                <div class="col-md-6">
                    <form:input id="addressBox" type="text" class="form-control" path="addressBox" />
                </div>
            </div>

            <div class="form-group row">
                <label path="addressPostalCode" class="col-md-4 col-form-label text-md-right">Code postal</label>
                <div class="col-md-6">
                    <form:input id="addressPostalCode" type="text" class="form-control" path="addressPostalCode" />
                </div>
            </div>

            <div class="form-group row">
                <label path="addressLocality" class="col-md-4 col-form-label text-md-right">Ville</label>
                <div class="col-md-6">
                    <form:input id="addressLocality" type="text" class="form-control" path="addressLocality" />
                </div>
            </div>

            <div class="form-group row">
                <label path="phoneNumber" class="col-md-4 col-form-label text-md-right">Numéro de téléphone</label>
                <div class="col-md-6">
                    <form:input id="phoneNumber" type="text" class="form-control" path="phoneNumber" />
                </div>
            </div>

            <div class="form-group row">
                <label path="sexe" class="col-md-4 col-form-label text-md-right">Sexe (optionel)</label>
                <div class="col-md-6">
                    <form:input id="sexe" type="text" class="form-control" path="sexe" />
                </div>
            </div>

            <div class="form-group row mb-0">
                <div class="col-md-8 offset-md-4">
                    <form:button class="btn btn-primary">M'inscrire</form:button>
                </div>
            </div>
        </form:form>
    </div>
</div>