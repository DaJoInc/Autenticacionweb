package com.ownk.aut.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.aut.model.RegistroPersona;
import com.ownk.aut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.aut.persistencia.dao.Registro;

public class GestionRegistroControllerDB {

	public RegistroPersona registrar(String nombre, String apellidos, BigInteger documento, String tipoDocumento, String correo, Date anoNacimiento, BigInteger telefono, String nickname, String contrasena) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		RegistroPersona registro = new RegistroPersona();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Registro dao = null;
		String codRespuesta;
		String msgRespuesta;
		String nicknames;

		/*
		 * ==============================================
		 * Se obtiene la session de la conexion JDBC con el
		 * framework de persistencia de la fabrica creada 
		 * en la clase DBManagerMyBatisBDApoyoConfig
		 * ************************************************* 
		 */
		session = DBManagerMyBatisApp.openSession();

		
		try {

			/*
			 * ==============================================
			 * Se obtiene el mapper declarado en la interfaz 
			 * GestionPINPaynetDao que posteriormente sera llamada 
			 * con el Mapa parametrosInOout para orquestar los parametros 
			 * y los handlers
			 * ************************************************* 
			 */
			dao = session.getMapper(Registro.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			parametrosInOout.put("p_idusuario",null );
			parametrosInOout.put("p_nombre",nombre );
			parametrosInOout.put("p_apellidos",apellidos);
			parametrosInOout.put("p_documento",documento );
			parametrosInOout.put("p_tipodocumento",tipoDocumento );
			parametrosInOout.put("p_correo",correo );
			parametrosInOout.put("p_anonacimiento", anoNacimiento);
			parametrosInOout.put("p_telefono",telefono );
			parametrosInOout.put("p_nickname",nickname );
			parametrosInOout.put("p_contrasena", contrasena);
			parametrosInOout.put("p_idusuarios", null);
			parametrosInOout.put("p_estado",null );
			parametrosInOout.put("cod_respuesta",null );
			parametrosInOout.put("msg_respuesta", null);

			dao.registro(parametrosInOout);

			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");

			if (codRespuesta!=null && msgRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					nicknames=(String)    parametrosInOout.get("p_nickname") ;
					registro.setCodRespuesta(codRespuesta);
					registro.setMsgRespuesta(msgRespuesta);
					registro.setNombre(nombre);
					registro.setApellidos(apellidos);
					registro.setDocumento(documento);
					registro.setTipoDocumento(tipoDocumento);
					registro.setCorreo(correo);
					registro.setAnoNacimiento(anoNacimiento);
					registro.setTelefono(telefono);
					registro.setNickname(nicknames);
					registro.setContrasena(contrasena);
				}else {
					registro.setCodRespuesta(codRespuesta);
					registro.setMsgRespuesta(msgRespuesta);
				}
			}else {
				registro.setCodRespuesta("ERROR");
				registro.setMsgRespuesta("No fue posible ejecutar el servicioA");
			}


		}catch (Exception e) {
			registro.setCodRespuesta("ERROR");
			registro.setMsgRespuesta("No fue posible ejecutar el servicioB");
		}finally {
			session.close();
		}

		return registro;

	}

}
