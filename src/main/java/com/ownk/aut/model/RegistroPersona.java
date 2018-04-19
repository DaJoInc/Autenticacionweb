package com.ownk.aut.model;

import java.math.BigInteger;
import java.util.Date;

public class RegistroPersona {
	
	private BigInteger 	idUsuario;
	private String     	nombre;
	private String	   	apellidos;
	private BigInteger	documento;
	private String     	tipoDocumento;
	private String	   	correo;
	private Date   	anoNacimiento;
	private BigInteger	telefono;
	private	String	    nickname;
	private String	    contrasena;
	private BigInteger	idUsuarios;
	private BigInteger	estado;
	private	String		codRespuesta;
	private String		msgRespuesta;

	public BigInteger getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public BigInteger getDocumento() {
		return documento;
	}
	public void setDocumento(BigInteger documento) {
		this.documento = documento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getAnoNacimiento() {
		return anoNacimiento;
	}
	public void setAnoNacimiento(Date anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}
	public BigInteger getTelefono() {
		return telefono;
	}
	public void setTelefono(BigInteger telefono) {
		this.telefono = telefono;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public BigInteger getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(BigInteger idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public BigInteger getEstado() {
		return estado;
	}
	public void setEstado(BigInteger estado) {
		this.estado = estado;
	}
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public String getMsgRespuesta() {
		return msgRespuesta;
	}
	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}
	
}
