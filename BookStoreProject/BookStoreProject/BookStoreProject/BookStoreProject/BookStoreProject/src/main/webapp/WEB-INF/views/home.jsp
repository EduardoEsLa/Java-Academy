<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" >
  <link rel="stylesheet" href="<c:url value="/css/custom.css"/>" >
  <title>Book Store</title>
</head>
<body>
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button"
                class="navbar-toggle collapsed"
                data-toggle="collapse"
                data-target="#navbar-collapse"
                aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="home">Book Store</a>
        <a class="navbar-brand" href="cart"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
      </div>
      <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="comments">Comments</a></li>
          <li><a href="${pageContext.request.contextPath}/spring_security_login">Log In</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle"
            data-toggle="dropdown" role="button"
            aria-haspopup="true"
            aria-expanded="false">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
    <div class="row">
      <div class="col-md-10 col-md-offset-1">
        <div class="page-header">
          <h1>Selling the classics!</h1>
        </div>
        <div class="row">
        <c:forEach var="item" items="${books}">
          <div class="col-md-4">
                      <p>${item.title}</p>
                      <p>${item.author}</p>
                      <p>${item.category}</p>
			          <p class="lead">$${item.price} USD</p>
					  <form:form method = "POST"  action = "addtocart/${item.id}" >
                          <button id="${item.id}" class="btn btn-default" type = "submit">
                              <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                          </button>
					  </form:form>
            <hr>
          </div>
          </c:forEach>         
        </div>
      </div>
    </div>
  </div>
  <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>