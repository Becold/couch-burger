<%@ include file="include/importTags.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
    Mot de passe hashé : ${password}
</div>
<div>
    Hello world

    <img src='<spring:url value="/images/romain.jpg" />' width="120px" height="auto" />
</div>

<form:form action="/send"
           method="POST"
           modelAttribute="magicKeyForm">

    <form:label path="magicKey">Magic key :</form:label>
    <form:input path="magicKey" />

    <form:button>Send</form:button>
</form:form>