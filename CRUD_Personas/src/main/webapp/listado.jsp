<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="/ListarPersonaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="resources/css/estilos.css">
<link rel="icon" href="resources/img/rocket.svg" type="img/png">

<title>Listado Personas</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/navbar.jsp" />
	
	<div class="container mt-4 mb-4">
		<div class="row">
			<div class="col-sm">
				<h1>Listado Personas Base de Datos</h1>
			</div>
		</div>
		<div class="row">
			<c:if test="${sessionScope.mensaje != null }">
				<div class="alert alert-success alert-dismissible fade show" role="alert">
	  				<strong>Holy guacamole!</strong> ${sessionScope.mensaje}
	  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			<c:if test="${sessionScope.error != null }">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  				<strong>Holy guacamole!</strong> ${sessionScope.error}
	  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
		</div>
		<c:if test="${not empty requestScope.personas}">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead class="table-dark">
						<th>Rut</th>
						<th>Nombre</th>
						<th>Email</th>
						<th>Edad</th>
						<th>País</th>
						<th colspan="2">Acciones</th>
					</thead>
					<tbody>
					<c:forEach items="${personas}" var="persona">
						<tr>
							<td>${persona.getRut()}</td>
							<td>${persona.getNombre()} ${persona.getApellido()}</td>
							<td>${persona.getEmail()}</td>
							<td>${persona.getEdad()}</td>
							<td>${persona.getPais()}</td>
							<td>
								<a href="modificar.jsp?rut=${persona.getRut()}">
									<i class="fa-regular fa-pen-to-square fa-2x text-primary"></i>
								</a>
                            </td>
                            <td>
								<a href="EliminarPersonaServlet?rut=${persona.getRut() }">
									<i class="fa-solid fa-trash fa-2x text-danger"></i>
								</a>
                            </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${empty requestScope.personas }">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
  				<strong>Holy guacamole!</strong> Actualmente no hay personas registradas en la base de datos.
  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>