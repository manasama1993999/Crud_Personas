<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
	ArrayList<String> errores = (ArrayList<String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="resources/css/estilos.css">
<link rel="icon" href="resources/img/rocket.svg" type="img/png">


<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/navbar.jsp" />

	<div class="container mt-4 mb-4">
		<c:if test="${not empty sessionScope.errores }">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				<c:forEach items="${errores}" var="e">
					<p><strong>${e}</strong></p>
	  			</c:forEach>
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<form action="RegistrarPersonaServlet" method="post">
						<div class="card-header bg-dark text-white">
							<h3 class="card-title">Ingrese los siguientes datos para su
								registro</h3>
						</div>
						<div class="card-body">
							<div class="input-group mb-3">
								<span class="input-group-text" id="nombre">Rut</span> <input
									type="text" class="form-control" placeholder="Ej. 12345678-9"
									name="txtRut">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="nombre">Nombre</span> <input
									type="text" class="form-control"
									placeholder="Ingrese su nombre" name="txtNombre">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="apellido">Apellido</span> <input
									type="text" class="form-control"
									placeholder="Ingrese su apellido" name="txtApellido">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="email">Email</span> <input
									type="email" class="form-control"
									placeholder="email@example.com" name="txtEmail">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="ocupacion">Edad</span> <input
									type="number" class="form-control"
									placeholder="Ej. 20" name="txtEdad">
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="genero">País</span> <input
									type="text" class="form-control"
									placeholder="País del cual provienes" name="txtPais">
							</div>
						</div>
						<div class="card-footer">
							<input class="btn btn-primary" type="submit" value="Registrar" />
							<input class="btn btn-secondary" type="reset" value="Limpiar" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>