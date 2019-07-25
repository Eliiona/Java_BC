<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      <style>

.login_header_1 h1{
	color: white;
	font-size: 70px;
	text-align: center;
	margin: 0;
	margin-top: 0;
	margin-right: 150px;
	padding-top: 30px;
	text-shadow: 5px 5px 2px #333

}

.login_header_2 h1{
	color: white;
	font-size: 70px;
	margin: 0;
	margin-left: 100px;
	margin-top: -10px;
	text-align: center;
	text-shadow: 5px 5px 2px #333
}
      </style>
  </head>

  <body style="background: rgba(62,70,80,1);">
      <div class="login_header_1">
          <h1>Code</h1>
        </div>
    
        <div class="login_header_2">
          <h1>Assist</h1>
        </div>

    <div class="container" style="
    width: -webkit-fit-content;
    height: -webkit-fit-content;
    width: -moz-fit-content;
    height: -moz-fit-content;
    background-color: rgba(241, 243, 243, 0.95);"
    >
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-secondary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>