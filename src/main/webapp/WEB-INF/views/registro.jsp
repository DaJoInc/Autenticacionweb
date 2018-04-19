
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Users</title>
<style>
.alert {
	padding: 20px;
	color: black;
	width: 200px;
}

.closebtn {
	margin-left: 15px;
	color: black;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: LightGrey;
}

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
		ng-controller="RegistroController as ctrl">



		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Formulario registro </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Nombre</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.nombre" name="nombre"
									class="nombre form-control input-sm"
									placeholder="Ingresar nombre" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.nombre.$error.required">Requiere
										nombre</span> <span ng-show="myForm.nombre.$error.minlength">Minimo
										de caracteres permitido son 3</span> <span
										ng-show="myForm.nombre.$invalid">Nombre invalido </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Apellidos</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.apellidos"
									name="apellidos" class="apellidos form-control input-sm"
									placeholder="Ingresar apellidos" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.apellidos.$error.required">Requiere
										apellidos</span> <span ng-show="myForm.apellidos.$error.minlength">Minimo
										de caracteres permitido son 3</span> <span
										ng-show="myForm.apellidos.$invalid">Apellidos invalidos
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Documento</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.documento"
									name="documento" class="documento form-control input-sm"
									placeholder="Ingresar documento" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.documento.$error.required">Requiere
										numero de documento</span> <span
										ng-show="myForm.documento.$error.minlength">Minimo de
										caracteres permitido son 3</span> <span
										ng-show="myForm.documento.$invalid">Documento invalido
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Tipo de
								documento</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.tipoDocumento"
									name="tipodocumento"
									class="tipodocumento form-control input-sm"
									placeholder="Ingresar tipo de documento" required
									ng-minlength="2" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.tipodocumento.$error.required">Requiere
										un tipo de documento</span> <span
										ng-show="myForm.tipodocumento.$error.minlength">Minimo
										de caracteres permitido son 2</span> <span
										ng-show="myForm.tipodocumento.$invalid">Tipo de
										documento invalido </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Correo</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.userDto.correo" name="correo"
									class="correo form-control input-sm"
									placeholder="Ingrese correo" required ng-minlength="6" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.correo.$error.required">Requiere
										que ingrese un correo</span> <span ng-show="myForm.correo.$invalid">Requiere
										que ingrese un correo</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Año de
								nacimiento</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.anoNacimiento"
									name="anonacimiento"
									class="anonacimiento form-control input-sm"
									placeholder="Ingrese año de nacimiento" required
									ng-minlength="6" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.anonacimiento.$error.required">Requiere
										una fecha de nacimiento</span> <span
										ng-show="myForm.anonacimiento.$error.minlength">Minimo
										de caracteres permitido son 6</span> <span
										ng-show="myForm.anonacimiento.$invalid">Fecha de
										nacimiento invalido </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Telefono</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.telefono"
									name="telefono" class="telefono form-control input-sm"
									placeholder="Ingrese telefono de contacto" required
									ng-minlength="6" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.telefono.$error.required">Requiere
										un telefono</span> <span ng-show="myForm.telefono.$error.minlength">Minimo
										de caracteres permitido son 6</span> <span
										ng-show="myForm.telefono.$invalid">Numero de telefono
										invalido </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Nombre
								de usuario</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userDto.nickname"
									name="nombreusuario"
									class="nombreusuario form-control input-sm"
									placeholder="Ingrese un nombre de usuario" required
									ng-minlength="6" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.nombreusuario.$error.required">Requiere
										un nombre de usuario</span> <span
										ng-show="myForm.nombreusuario.$error.minlength">Minimo
										de caracteres permitido son 6</span> <span
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
									placeholder="Ingrese una contrasena" required ng-minlength="6" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.contrasena.$error.required">Requiere
										una contrasena</span> <span
										ng-show="myForm.contrasena.$error.minlength">Minimo de
										caracteres permitido son 6</span> <span
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
											ng-repeat="r in ctrl.userDto  | filter:{codRespuesta:'OK'}:true">
											<strong>{{r.codRespuesta}} : Bienvenido(a)</strong>

											<button type="button" class="btn btn-default"
												data-dismiss="modal"
												onclick="javascript:location.href='http://localhost:8089/JodaAutenticacion/'">Close</button>
										</p>

										<p
											ng-repeat="r in ctrl.userDto  | filter:{codRespuesta:'Error'}:true">
											<strong>La persona ya se encuentra registrada</strong>

											<button type="button" class="btn btn-default"
												data-dismiss="modal"
												onclick="javascript:location.href='http://localhost:8089/JodaAutenticacion/registro/'">Close</button>
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
	<script src="<c:url value='/static/js/service/registro_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/registro_controller.js' />"></script>
</body>
</html>