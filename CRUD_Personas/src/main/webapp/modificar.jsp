<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="/BuscarPersonaServlet?rut=${param.rut }" />
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

	<c:if test="${not empty requestScope.personaBuscada }">
	<div class="container mt-4 mb-4">		
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<form action="ModificarPersonaServlet" method="post">
						<div class="card-header bg-dark text-white">
							<h3 class="card-title">Ingrese los siguientes datos para su modificación</h3>
						</div>
						<div class="card-body">
							<div class="input-group mb-3">
								<span class="input-group-text" id="nombre">Rut</span> 								
								<input
									type="text" class="form-control" placeholder="Ej. 12345678-9"
									name="txtRut" value=${personaBuscada.getRut() } disabled>
								<input
									type="text" class="form-control" placeholder="Ej. 12345678-9"
									name="txtRutBuscado" hidden="true" value=${personaBuscada.getRut() } >
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="nombre">Nombre</span> <input
									type="text" class="form-control"
									placeholder="Ingrese su nombre" name="txtNombre" value=${personaBuscada.getNombre() }>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="apellido">Apellido</span> <input
									type="text" class="form-control"
									placeholder="Ingrese su apellido" name="txtApellido" value=${personaBuscada.getApellido() }>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="email">Email</span> <input
									type="email" class="form-control"
									placeholder="email@example.com" name="txtEmail" value=${personaBuscada.getEmail() }>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="ocupacion">Edad</span> <input
									type="number" class="form-control"
									placeholder="Ej. 20" name="txtEdad" value=${personaBuscada.getEdad() }>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="genero">País</span> <input
									type="text" class="form-control"
									placeholder="País del cual provienes" name="txtPais" value=${personaBuscada.getPais() }>
							</div>
						</div>
						<div class="card-footer">
							<input class="btn btn-primary" type="submit" value="Modificar" />
							<a href="listado.jsp" class="btn btn-secondary" >Cancelar</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</c:if>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>