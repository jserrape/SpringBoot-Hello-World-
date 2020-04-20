<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD SPRING BOOT H2</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<form action="/agregarCatalogo" method="POST" class="col-sm-5" enctype="multipart/form-data">
			<div class="card">
				<div class="card-header">
					<h4>Agregar Catalogo</h4>
				</div>
				<div class="card-body">					
					<div class="form-group">
						<label>TIPO</label> <input type="text" name="tipo" class="form-control">
					</div>
					<div class="form-group">
						<label>FILE</label> <input type="file" name="file" class="form-control"/>
					</div>
				</div>
				<div class="card-footer">
					<input type="submit" value="Guardar" class="btn btn-info" /> 
					<a href="/listarCatalogo" class="btn btn-link">Regresar</a>
				</div>
			</div>
		</form>

	</div>
</body>
</html>