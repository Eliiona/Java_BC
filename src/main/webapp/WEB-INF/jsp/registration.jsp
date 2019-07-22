<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Register</title>
      <link rel="stylesheet" href="/resources/css/style.css">
      <link href="css/style.css" rel="stylesheet" type="text/css">
      <!-- <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> -->
  </head>
  <body class="background">

    <div class="container" >
        <div class="login_header_1">
            <h1>Code</h1>
        </div>
              
        <div class="login_header_2">
            <h1>Assist</h1>
        </div>

        <form:form name="form" class="signup" method="POST" modelAttribute="userForm">
                <div class="container">
            <h2 class="form-signin-heading">Create your account</h2>
            <p>Please fill in this form to create an account.</p>
                    <hr>
            <spring:bind path="username">

                <label for="user"><b>Bootcamp ID </b></label><br>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Aaaa"
                    pattern="[a-zA-Z0-9]{4}" title="Must match given bootcamp code pattern" autofocus="true"></form:input><br>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="name">
                    <label for="name"><b>Name </b></label><br>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="Name"
                    pattern="^[A-Z][a-zA-Z]{1,19}" title="Must 2-20 letters long containing only 
                    latin letters, starting with capital letter." autofocus="true"></form:input>
                    <form:errors path="name"></form:errors><br>
                </div>
            </spring:bind>
            
            <spring:bind path="surname">
                    <label for="lastname"><b>Surname </b></label><br>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="surname" class="form-control" placeholder="Surname"
                    pattern="^[A-Z][a-zA-Z]{1,19}" title="Must 2-20 letters long containing only 
                    latin letters, starting with capital letter." autofocus="true"></form:input><br>
                    <form:errors path="surname"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                    <label for="psw"><b>Password</b></label><br>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"
                    id="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title="Must contain at least 
                    one number and one uppercase and lowercase letter, and at least 8 characters up to 20"
                    oninput="check(document.getElementById('psw2'))"></form:input><br>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                    <label for="psw2"><b>Repeat Password</b></label><br>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control" id="psw2" 
                    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title="Must match given password" 
                    oninput="check(this)" placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>
            <a href="/"><button type="button" class="cancelbtn">Cancel</button></a>

            <button class="signupbtn" type="submit">Register</button></div>
        </form:form>

    </div>
    <script language='javascript' type='text/javascript'>
        function check(input) {
            // Checks passed object value against object with id=psw, returns invalidity
            if (input.value != document.getElementById('psw').value) {
                input.setCustomValidity('Password must be matching');
            } else {
                // input is valid -- reset the error message
                input.setCustomValidity('');
            }
        }
      </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
