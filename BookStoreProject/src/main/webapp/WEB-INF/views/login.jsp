<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body id="signInBody">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <h2>Book Store</h2>
        <h3>Sign in</h3>
        <form>
          <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>    
          <div class="form-group">
            <input type="submit" class="form-control btn btn-primary" value="Sign in">
          </div>
        </form>
      </div>
    </div>
  </div>
  <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>