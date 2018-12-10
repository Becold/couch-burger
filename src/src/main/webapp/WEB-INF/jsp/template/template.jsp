<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <link rel="icon" type="image/png" href="<spring:url value='/images/favicon.png' />" />

    <link type="text/css" rel="Stylesheet" href="<spring:url value='/css/bootstrap.min.css' />" />
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="<spring:url value='/' />">Couch'Burger</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"> <!-- TODO page "active" à gérer -->
                    <a class="nav-link" href="<spring:url value='/' />">Accueil</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Catégories
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Poulet</a>
                        <a class="dropdown-item" href="#">Poisson</a>
                        <a class="dropdown-item" href="#">Viande hachée</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Boisson</a>
                        <a class="dropdown-item" href="#">Sauce</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mon Panier <span class="badge badge-danger">3</span></a>
                </li>
            </ul>

            <div class="d-inline mr-5">
                <sec:authorize access="!isAuthenticated()">
                    <a class="btn btn-primary mr-sm-2" href="<spring:url value='/login'/>">Se connecter</a>
                    <a class="btn btn-outline mr-sm-2" href="<spring:url value='/register'/>">S'inscrire</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    ${pageContext.request.userPrincipal.name}


                    <div>
                        <li class="d-inline dropdown">
                            <a class="dropdown-toggle" href="#" id="settingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Parametres
                            </a>
                            <div class="dropdown-menu" aria-labelledby="settingDropdown">
                                <a class="dropdown-item" href="<spring:url value='/authenticated'/>">
                                    Mon profil
                                </a>
                                <a class="dropdown-item" href="<spring:url value='/logout'/>">
                                    Se déconnecter
                                </a>
                            </div>
                        </li>
                    </div>
                </sec:authorize>
            </div>
            <div>
                <li class="d-inline dropdown">
                    <a class="dropdown-toggle" href="#" id="langDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Langue
                    </a>
                    <div class="dropdown-menu" aria-labelledby="langDropdown">
                        <a class="dropdown-item" href="#">
                            <img src="/images/flag/fr.png" width="32px" height="auto" /> Français
                        </a>
                        <a class="dropdown-item" href="#">
                            <img src="/images/flag/us.png" width="32px" height="auto" /> English
                        </a>
                    </div>
                </li>
            </div>
        </div>
    </div>
</nav>


<div class="container">
    <tiles:insertAttribute name="main-content" />
</div>


<div class="container">
    <hr>

    <footer>
        <p>&copy; Couch'Burger 2018</p>
        <sec:authorize access="hasRole('ADMIN')">
            <a href="<spring:url value='/admin' />">Administration du site</a>
        </sec:authorize>
    </footer>
</div>


<script src="/js/vendor/jquery.min.js"></script>
<script src="/js/vendor/bootstrap.min.js"></script>
<script src="/js/main.js"></script>

</body>
</html>