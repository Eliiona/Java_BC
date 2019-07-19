<!DOCTYPE html>
<html lang="en" xmlns:th="www.thymeleaf.org">
<head>
    <title>Sign up</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../static/css/style.css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="background">
  <div>

    <div class="login_header_1">
      <h1>Code</h1>
    </div>

    <div class="login_header_2">
      <h1>Assist</h1>
    </div>

    <form name="form" class="signup" method="POST" action="#" th:action="@{/signup}" th:object="${user}">
        <div class="container">
          <h1>Sign Up</h1>
          <p>Please fill in this form to create an account.</p>
          <hr>
      <span>
          <label for="user"><b>Bootcamp ID </b></label><br>
          <input class = "signup" type="text" placeholder="AAAA" name="user" required pattern="[a-zA-Z0-9]{4}" 
          title="Must match given bootcamp code pattern"><br>
      </span>
      <div>
          <label for="name"><b>Name </b></label><br>
          <input class = "signup" type="text" placeholder="Enter your name" name="name" required pattern="^[A-Z][a-zA-Z]{1,19}" 
          title="Must 2-20 letters long containing only latin letters, starting with capital letter.">
      </div>
          <div>
            <label for="lastname"><b>Surname </b></label><br>
            <input class = "signup" type="text" placeholder="Enter your surname" name="lastname" required pattern="^[A-Z][a-zA-Z]{1,19}" 
            title="Must 2-20 letters long containing only latin letters, starting with capital letter.">
          </div>
      
          <div>
              <label for="psw"><b>Password</b></label><br>
              <input id = "psw" class = "signup" type="password" placeholder="Enter Password" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" 
              title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 characters up to 20" required 
              oninput="check(document.getElementById('psw2'))">
          </div>
      
          <div>
              <label for="psw2"><b>Repeat Password</b></label><br>
              <input id = "psw2" class = "signup" type="password" placeholder="Repeat Password" name="psw2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" 
              title="Must match given password" oninput="check(this)">
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
          <div class="clearfix">
            <a href="/"><button type="button" class="cancelbtn">Cancel</button></a>
            <button type="submit" class="signupbtn">Sign Up</button>
          </div>
        </div>
      </form> 
    </div>
    <script>
        //Takes message from Thymeleaf and displays it. Triggered when user is already registered with that code
        var showtext = "[[${message}]]";
        if (showtext != "[[${message}]]"){
            window.alert(showtext);
        }
    </script>
</body>
</html>