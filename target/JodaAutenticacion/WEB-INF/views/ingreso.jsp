
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Ingreso</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="IngresoController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Ingreso</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Nombre
								de usuario</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.nickname"
									name="nombreusuario"
									class="nombreusuario form-control input-sm"
									placeholder="Ingrese un nombre de usuario" required
									ng-minlength="4" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.nombreusuario.$error.required">Requiere
										un nombre de usuario</span> <span
										ng-show="myForm.nombreusuario.$error.minlength">Minimo
										de caracteres permitido son 4</span> <span
										ng-show="myForm.nombreusuario.$invalid">Numero de
										usuario invalido </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Ingrese
								contraseñna</label>
							<div class="col-md-7">
								<input type="password" ng-model="ctrl.userDto.contrasena"
									name="contrasena" class="contrasena form-control input-sm"
									placeholder="Ingrese una contrasena" required ng-minlength="4" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.contrasena.$error.required">Requiere
										una contrasena</span> <span
										ng-show="myForm.contrasena.$error.minlength">Minimo de
										caracteres permitido son 4</span> <span
										ng-show="myForm.contrasena.$invalid">Contrasena
										invalido </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row" class="container">
						<input type="submit" value="Ingreso" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#myModal"
							ng-disabled="myForm.$invalid">
						<!-- Modal -->
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>

										<p
											ng-repeat="r in ctrl.userDto  | filter:{codRespuesta:'Ok'}:true">
											<strong>{{r.codRespuesta}} : Bienvenido(a)</strong>

											<button type="button" class="btn btn-default"
												data-dismiss="modal"
												onclick="javascript:location.href='http://localhost:8089/JodaAutenticacion/'">Close</button>
										</p>

										<p
											ng-repeat="r in ctrl.userDto  | filter:{codRespuesta:'Error'}:true">
											<strong>{{r.codRespuesta}} : Su usuario no ha sido
												autorisado para ingresar</strong>

											<button type="button" class="btn btn-default"
												data-dismiss="modal"
												onclick="javascript:location.href='http://localhost:8089/JodaAutenticacion/ingreso/'">Close</button>
										</p>

										<p
											ng-repeat="r in ctrl.userDto  | filter:{codRespuesta:'ERROR'}:true">
											<strong>{{r.codRespuesta}} : Usuario o contraseña
												incorrecta</strong>

											<button type="button" class="btn btn-default"
												data-dismiss="modal"
												onclick="javascript:location.href='http://localhost:8089/JodaAutenticacion/ingreso/'">Close</button>
										</p>

									</div>

								</div>
							</div>
						</div>
						</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/ingreso_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/ingreso_controller.js' />"></script>
</body>
</html>