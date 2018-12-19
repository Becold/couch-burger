<%@ include file="include/importTags.jsp" %>


<div class="container">
    <div class="card card-default">
        <div class="card-header"><spring:message code="register.register" /></div>
        <div class="card-body">
            <form:form
                    method="POST"
                    action=""
                    modelAttribute="userRegister">
                <div class="form-group row">
                    <form:label path="username" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.username" /></form:label>
                    <div class="col-md-6">
                        <form:input id="username" type="text" class="form-control" path="username" />
                        <form:errors path="username" />
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="email" class="col-sm-4 col-form-label text-md-right"><spring:message code="register.email" /></form:label>
                    <div class="col-md-6">
                        <form:input id="email" type="text" class="form-control" path="email" />
                        <form:errors path="email" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="password" class="col-md-4 col-form-label text-md-right"><spring:message code="register.password" /></label>
                    <div class="col-md-6">
                        <form:input id="password" type="password" class="form-control" path="password" />
                        <form:errors path="password" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="confirmPassword" class="col-md-4 col-form-label text-md-right"><spring:message code="register.confirmpw" /></label>
                    <div class="col-md-6">
                        <form:input id="confirmPassword" type="password" class="form-control" path="confirmPassword" />
                        <form:errors path="confirmPassword" />
                    </div>
                </div>

                <hr>

                <div class="form-group row">
                    <label path="firstname" class="col-md-4 col-form-label text-md-right"><spring:message code="register.firstname" /></label>
                    <div class="col-md-6">
                        <form:input id="firstname" type="text" class="form-control" path="firstname" />
                        <form:errors path="firstname" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="name" class="col-md-4 col-form-label text-md-right"><spring:message code="register.lastname" /></label>
                    <div class="col-md-6">
                        <form:input id="name" type="text" class="form-control" path="name" />
                        <form:errors path="name" />
                    </div>
                </div>

                <hr>

                <div class="form-group row">
                    <label path="addressStreetName" class="col-md-4 col-form-label text-md-right"><spring:message code="register.street" /></label>
                    <div class="col-md-6">
                        <form:input id="addressStreetName" type="text" class="form-control" path="addressStreetName" />
                        <form:errors path="addressStreetName" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="addressNumber" class="col-md-4 col-form-label text-md-right"><spring:message code="register.streetnb" /></label>
                    <div class="col-md-6">
                        <form:input id="addressNumber" type="text" class="form-control" path="addressNumber" />
                        <form:errors path="addressNumber" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="addressBox" class="col-md-4 col-form-label text-md-right"><spring:message code="register.box" /></label>
                    <div class="col-md-6">
                        <form:input id="addressBox" type="text" class="form-control" path="addressBox" />
                        <form:errors path="addressBox" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="addressPostalCode" class="col-md-4 col-form-label text-md-right"><spring:message code="register.postalcode" /></label>
                    <div class="col-md-6">
                        <form:input id="addressPostalCode" type="number" class="form-control" path="addressPostalCode" />
                        <form:errors path="addressPostalCode" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="addressLocality" class="col-md-4 col-form-label text-md-right"><spring:message code="register.town" /></label>
                    <div class="col-md-6">
                        <form:input id="addressLocality" type="text" class="form-control" path="addressLocality" />
                        <form:errors path="addressLocality" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="phoneNumber" class="col-md-4 col-form-label text-md-right"><spring:message code="register.phonenumber" /></label>
                    <div class="col-md-6">
                        <form:input id="phoneNumber" type="text" class="form-control" path="phoneNumber" />
                        <form:errors path="phoneNumber" />
                    </div>
                </div>

                <div class="form-group row">
                    <label path="sexe" class="col-md-4 col-form-label text-md-right"><spring:message code="register.sexe" /></label>
                    <div class="col-md-6">
                        <label class="radio-inline"><form:radiobutton path="sexe" value="M" checked="true" /> M</label>
                        <label class="radio-inline"><form:radiobutton path="sexe" value="F" /> F</label>
                        <br><form:errors path="sexe" />
                    </div>
                </div>

                <div class="form-group row mb-0">
                    <div class="col-md-8 offset-md-4">
                        <form:button class="btn btn-primary"><spring:message code="register.register" /></form:button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>