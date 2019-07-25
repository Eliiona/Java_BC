
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body style="background: rgba(62,70,80,1);">

    <div class="container" style="
        width: -webkit-fit-content;
        height: -webkit-fit-content;
        width: -moz-fit-content;
        height: -moz-fit-content;
        background-color: rgba(241, 243, 243, 0.95);
    ">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username" pattern="[a-zA-Z0-9]{4,8}" 
                    title="Must contain only letters and numbers and be 4-8 chars long"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="Name" pattern="^[A-Z][a-zA-Z]{1,19}" 
                    title="Must 2-20 letters long containing only latin letters, starting with capital letter."
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="surname">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="surname" class="form-control" placeholder="Surname" pattern="^[A-Z][a-zA-Z]{1,19}" 
                    title="Must 2-20 letters long containing only latin letters, starting with capital letter."
                                autofocus="true"></form:input>
                    <form:errors path="surname"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input id = "psw" type="password" path="password" class="form-control" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" 
                    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 characters up to 20"
                    oninput="check(document.getElementById('psw2'))"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control" title="Must match previously typed password" oninput="check(this)"
                                placeholder="Confirm your password" id="pws2"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
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
