<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
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
      </div>
      <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
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
  <div class="modal fade" id="modal" tabindex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          <h4 class="modal-title">Add new book</h4>
        </div>
        <div class="modal-body">
          <form:form commandName="book" action="addbook" method="post">
            <div class="form-group">
              <form:input class="form-control" path="title" placeholder="Title"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="author" placeholder="Author"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="category" placeholder="Category"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="publisher" placeholder="Publisher"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="edition" placeholder="Edition"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="year" placeholder="Year"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="isbn" placeholder="ISBN"/>
            </div>
            <div class="form-group">
              <form:input class="form-control" path="price" placeholder="Price"/>
            </div>
          </form:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button id="submitFormBtn" type="submit" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
          <div class="panel-heading">Books</div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-6" style="padding-right:5px;">
                  <div class="input-group">
                    <span class="input-group-addon" id="search-addon">
                      <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </span>
                    <input type="text" class="form-control" aria-describedby="search-addon" placeholder="Search">
                  </div>
                </div>
                <div class="input-group">
                  <button id="newBook" class="btn btn-default"
                  data-toggle="modal"
                  data-target="#modal" data-event="New book">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                  </button>
                </div>
              </div>
              <div class="row" style="padding-top:15px;">
                <div class="col-lg-12">
                  <table class="table table-condensed" id="booksTable">
                    <thead>
                      <tr>
                      	<th></th>
                        <th>#</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>ISBN</th>
                        <th>Price</th>
                        <th>Edit</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${books}">
                    <tr>
                      <td>
						<form:form method="POST"  action="removebook/${item.id}">
	                        <button id="${item.id}" class="btn btn-default" type = "submit">
	                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
	                        </button>
						</form:form>
                      </td>
                      <td>${item.id}</td>
                      <td>${item.title}</td>
                      <td>${item.author}</td>
                      <td>${item.isbn}</td>
                      <td>$${item.price}</td>
                      <td>
                        <button id="${item.id}" class="btn btn-default" data-toggle="modal" data-target="#modal"
                        data-event="Edit book">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </button>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="<c:url value="/js/jquery-1.11.3.min.js"/>"></script>
  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  <script>
  $('#modal').on('show.bs.modal', function (event) {
	$('form div input').val("");
    var button = $(event.relatedTarget);
    var data = button.data('event');
    var btnText = (data == "New book") ? "Save" : "Save changes";
    
    var modal = $(this);
    modal.find('.modal-title').text(data);
    modal.find('.modal-footer .btn-primary').text(btnText);
    
    if (btnText === "Save changes") {
    	$('form').attr('action', 'updatebook');
    } else {
    	$('form').attr('action', 'addbook');
    	$("#delete").hide();
    }
  });
  
  $('#submitFormBtn').click(function() {
	  $('#book').submit();
  });
    
  $('td button').click(function () {
	  	var id = this.id;
	  	
  		$.post('book/' + id, function (data, status) {
			$('form').attr('action', 'updatebook/' + id);
	  		$('#title').val(data.title);
	  		$('#author').val(data.author);
	  		$('#category').val(data.category);
	  		$('#edition').val(data.edition);
	  		$('#publisher').val(data.publisher);
	  		$('#year').val(data.year);
	  		$('#isbn').val(data.isbn);
	  		$('#price').val(data.price);
  		}, 'json');
	});
  </script>
</body>
</html>
