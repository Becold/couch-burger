<%@ include file="include/importTags.jsp" %>

<c:if test="${param.error}">
    <div class="alert alert-danger">
        <spring:message code="login.invalid" />
    </div>
</c:if>

<c:if test="${param.logout}">
    <div class="alert alert-success">
        <spring:message code="login.disconnect" />
    </div>
</c:if>

<form:form
    method="post"
    action=""
    modelAttribute="userDetails">

    <div class="form-group row">
        <form:label path="username" class="col-sm-4 col-form-label text-md-right"><spring:message code="login.username" /></form:label>
        <div class="col-md-6">
            <form:input type="text" class="form-control" path="username" /><br>
            <form:errors path="username" />
        </div>
    </div>

    <div class="form-group row">
        <form:label path="password" class="col-md-4 col-form-label text-md-right"><spring:message code="login.password" /></form:label>
        <div class="col-md-6">
            <form:input type="password" class="form-control" path="password" /><br>
            <form:errors path="password" />
        </div>
    </div>

    <div class="form-group row mb-0">
        <div class="col-md-8 offset-md-4">
            <form:button class="btn btn-primary"><spring:message code="login.login" /></form:button>
        </div>
    </div>
</form:form>