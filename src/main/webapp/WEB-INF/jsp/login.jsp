<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>
      <link rel="stylesheet" href="../resources/css/style.css">


      <!-- <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> -->
  </head>

  <body class="background">
      <div class="container">
      <div class="login_header_1">
          <h1>Code</h1>
        </div>
    
        <div class="login_header_2">
          <h1>Assist</h1>
        </div>

    
      <form method="POST" action="${contextPath}/login" class="login">
        <div class="container">
        <h2 class="form-heading">Login</h2>
        <p>Please fill in this form to login.</p>
	          <hr>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>

            <input name="username" type="text" class="form-control" placeholder="Bootcamp ID"
                   autofocus="true"/><br>
                   
            <input name="password" type="password" class="form-control" placeholder="Password"/><br>

            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="loginbtn" type="submit">Login</button>
            <hr style="margin-top: 30px;">
	          <p>Register new account.</p>
            <button type="submit" class="loginbtn" href="${contextPath}/registration">Create an account</button>
        </div>
      </div>
      </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
