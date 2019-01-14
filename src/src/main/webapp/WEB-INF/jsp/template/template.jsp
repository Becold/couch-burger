<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/importTags.jsp" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="type=text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Couch'Burger - ${title}</title>

    <link rel="icon" type="image/png" href="<spring:url value='/images/favicon.png' />" />

    <link type="text/css" rel="Stylesheet" href="<spring:url value='/css/all.min.css' />" />
    <link type="text/css" rel="Stylesheet" href="<spring:url value='/css/bootstrap.min.css' />" />
    <link type="text/css" rel="Stylesheet" href="<spring:url value='/css/style.css' />" />
</head>

<body class="${classCss}">

<nav class="navbar navbar-expand-lg navbar-light bg-light" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="<spring:url value='/' />">Couch'Burger</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<spring:url value='/' />">
                        <spring:message code="menu.home" />
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<spring:url value='/cart' />">
                        <spring:message code="menu.cart" />
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<spring:url value='/promotions' />">
                        <spring:message code="menu.promo" />
                    </a>
                </li>
            </ul>

            <div class="d-inline mr-5">
                <sec:authorize access="!isAuthenticated()">
                    <a class="btn btn-primary mr-sm-2" href="<spring:url value='/login'/>">
                        <spring:message code="menu.login" />
                    </a>
                    <a class="btn btn-outline mr-sm-2" href="<spring:url value='/register'/>">
                        <spring:message code="menu.register" />
                    </a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <spring:message code="menu.welcomeUser" />${pageContext.request.userPrincipal.name}

                    <div>
                        <li class="d-inline dropdown">
                            <a class="dropdown-toggle" href="#" id="settingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <spring:message code="menu.settings" />
                            </a>
                            <div class="dropdown-menu" aria-labelledby="settingDropdown">
                                <a class="dropdown-item" href="<spring:url value='/authenticated'/>">
                                    <spring:message code="menu.profile" />
                                </a>
                                <a class="dropdown-item" href="<spring:url value='/logout'/>">
                                    <spring:message code="menu.disconnect" />
                                </a>
                            </div>
                        </li>
                    </div>
                </sec:authorize>
            </div>
            <div>
                <li class="d-inline dropdown">
                    <a class="dropdown-toggle" href="#" id="langDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <spring:message code="menu.language" />
                    </a>
                    <div class="dropdown-menu" aria-labelledby="langDropdown">
                        <spring:url var="localeFr" value="">
                            <spring:param name="locale" value="fr" />
                            <c:if test="${param.code != null}">
                                <spring:param name="code" value="${param.code}" />
                            </c:if>
                        </spring:url>
                        <spring:url var="localeEn" value="">
                            <spring:param name="locale" value="en" />
                            <c:if test="${param.code != null}">
                                <spring:param name="code" value="${param.code}" />
                            </c:if>
                        </spring:url>
                        <a class="dropdown-item" href="${localeFr}">
                            <img src="/images/flag/fr.png" width="32px" height="auto" /> <spring:message code="language.french" />
                        </a>
                        <a class="dropdown-item" href="${localeEn}">
                            <img src="/images/flag/us.png" width="32px" height="auto" /> <spring:message code="language.english" />
                        </a>
                    </div>
                </li>
            </div>
        </div>
    </div>
</nav>


<tiles:insertAttribute name="main-content" />


<div class="container">
    <hr>

    <footer>
        <p>&copy; Couch'Burger 2018 <a style="float : right" href="<spring:url value='/more_details'/>"><spring:message code="menu.moreDetails" /></a></p>
    </footer>
</div>


<script src="/js/vendor/jquery.min.js"></script>
<script src="/js/vendor/bootstrap.min.js"></script>
<script src="/js/main.js"></script>

</body>
</html>