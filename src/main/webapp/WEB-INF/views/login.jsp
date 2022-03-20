<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


</head>
<body class="bg-info">

	<div class="card bg-dark ">

		<div class="card-body">
			<h4 class="card-title text-center text-white">Book Management
				System</h4>
		</div>
	</div>

	<div class="container mt-5 ">


		<div class="row d-flex justify-content-center">
			<div class="card px-5 py-5 " id="form1">


				<form action="processForm " method="post">


					<div class="mb-3 row">
						<label for="User Name" class="col-sm-4 col-form-label">username</label>
						<div class="col-sm-6">
							<input type="text" name="username" class="form-control">
						</div>
					</div>


					<div class="mb-3 row">
						<label for="password" class="col-sm-4 col-form-label">password</label>
						<div class="col-sm-6">
							<input type="password" name="password" class="form-control">
						</div>
					</div>
					

						<div class=" m-3 p-2">
							<button input type="submit" class="btn btn-primary w-100">Login</button>
						</div>
					
				</form>

				<form action="register">

					<div class="row d-flex justify-content-center">
						<div class="mb-3">
							<button input type="submit" class="btn btn-primary w-100">create
								an account</button>
						</div>
					</div>



				</form>
			</div>
		</div>
	</div>


</body>
</html>