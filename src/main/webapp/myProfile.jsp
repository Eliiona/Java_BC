<!DOCTYPE html>
<html lang="en" xmlns:th="www.thymeleaf.org">
<head>
	<title>My Profile</title>
	<link rel="stylesheet" href="../static/css/style.css">
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="main_div">
		<div class="static_header_bar">
	        <div class="profile_logout_buttons">
	        	<p><a href="">My profile</a></p>
	        	<p><a href="">Log out</a></p>
	        </div>

	        <div class="title">
	        	<h4>Code</h4>
	        	<h4>Assist</h4>
	    	</div>

	    	<div class="creat_new_issue_button">
	        	<p><a href="">Create new issue</a></p>
	        </div>
		</div>

		<div class="exercise_side_bar">
			<button type="button" class="btn btn-light">Activity 01</button>
			<button type="button" class="btn btn-light">Activity 02</button>
			<button type="button" class="btn btn-light">Activity 04</button>
			<button type="button" class="btn btn-light">Activity 04</button>
			<button type="button" class="btn btn-light">Activity 05</button>
			<button type="button" class="btn btn-light">Activity 06</button>
			<button type="button" class="btn btn-light">Activity 07</button>
			<button type="button" class="btn btn-light">Activity 08</button>
			<button type="button" class="btn btn-light">Activity 09</button>
			<button type="button" class="btn btn-light">Activity 10</button>
			<button type="button" class="btn btn-light">Activity 11</button>
			<button type="button" class="btn btn-light">Activity 12</button>
			<button type="button" class="btn btn-light">Activity 13</button>
			<button type="button" class="btn btn-light">Activity 14</button>
			<button type="button" class="btn btn-light">Activity 15</button>
			<button type="button" class="btn btn-light">Activity 16</button>
			<button type="button" class="btn btn-light">Activity 17</button>
			<button type="button" class="btn btn-light">Activity 18</button>
			<button type="button" class="btn btn-light">Extra 01</button>
			<button type="button" class="btn btn-light">Extra 02</button>
			<button type="button" class="btn btn-light">Extra 03</button>
			<button type="button" class="btn btn-light">Extra 04</button>
			<button type="button" class="btn btn-light">Extra 05</button>
			<button type="button" class="btn btn-light">Extra 06</button>
			<button type="button" class="btn btn-light">Extra 07</button>
			<button type="button" class="btn btn-light">Extra 08</button>
			<button type="button" class="btn btn-light">Extra 09</button>
			<button type="button" class="btn btn-light">Extra 10</button>
			<button type="button" class="btn btn-light">Extra 11</button>
			<button type="button" class="btn btn-light">Extra 12</button>
		</div>

		<div class="work_box">
			<h2>My questions</h2>
			

				<div class="myquestion_box" th:each="issue:${issueList}">
					<p th:text="${issue.exercise}"></p>
					<p th:text="${issue.getTitle()}"><a href="/">Issue title</a></p>
					<p style="display: inline-block;" >Posted by:</p>	
					<p style="display: inline-block;" th:text="${issue.getUser().getUsername()}">abcd</p>
					<p style="display: inline-block;" >Date: </p>
					<p style="display: inline-block;" th:text="${issue.getDate()}">16.07.2019</p>
					<p style="text-align: left; font-weight: bold; padding-left: 20px;">Description:</p>
					<p style="text-align:left; padding-left: 20px;"th:text="${issue.getDescription()}">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>			
				</div>	

			
		</div>
	</div>
	<script type="text/javascript" th:inline="javascript">
			var list = '${issueList}';
		console.log(list);
	</script>
</body>
</html>