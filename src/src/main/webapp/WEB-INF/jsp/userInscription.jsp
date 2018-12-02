<%@ include file="include/importTags.jsp" %>

<div class="alert alert-success">
Bon mot de passe!
</div>

<form:form action="/inscription"
           method="POST"
           modelAttribute="currentUser">

    <div class="form-group">
        <form:label path="name" cssClass="form-label">Name:</form:label>
        <form:input path="name" cssClass="form-control" />
    </div>

    <div class="form-group">
        <form:label path="age" cssClass="form-label">Age</form:label>
        <form:input path="age" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <form:radiobutton path="male" value="true" label=" Male" />
        <form:radiobutton path="male" value="false" label=" Girl"/>
    </div>

    <div class="form-group">
        <form:label path="hobby" cssClass="form-label">What's your favorite hobby? </form:label>
        <form:select path="hobby" cssClass="form-control">
            <form:options items="${hobbies}" itemValue="id" itemLabel="name" />
        </form:select>
    </div>

    <div>
        <form:button cssClass="btn btn-primary">Send</form:button>
    </div>
</form:form>