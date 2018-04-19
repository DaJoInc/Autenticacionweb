package com.ownk.aut.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.aut.model.IngresoUsuarios;
import com.ownk.aut.model.RegistroPersona;
import com.ownk.aut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.aut.persistencia.dao.Ingreso;

public class GestionIngresoControllerDB {
	
	public IngresoUsuarios ingresar(String nickname, String contrasena) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		IngresoUsuarios registro = new IngresoUsuarios();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Ingreso dao = null;
		String codRespuesta;
		String msgRespuesta;
		String idUsuario;
		String nicknames;

		/*
		 * ==============================================
		 * Se obtiene la session de la conexion JDBC con el
		 * framework de persistencia de la fabrica creada 
		 * ************************************************* 
		 */
		session = DBManagerMyBatisApp.openSession();

		
		try {

			/*
			 * ==============================================
			 * Se obtiene el mapper declarado en la interfaz 
			 * Ingreso que posteriormente sera llamada 
			 * con el Mapa parametrosInOout para orquestar los parametros 
			 * y los handlers
			 * ************************************************* 
			 */
			dao = session.getMapper(Ingreso.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			
			parametrosInOout.put("p_nickname",nickname );
			parametrosInOout.put("p_contrasena", contrasena);
			parametrosInOout.put("cod_respuesta",null );
			parametrosInOout.put("id_usuario",null );
			parametrosInOout.put("msg_respuesta", null);

			dao.ingreso(parametrosInOout);
			
			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			idUsuario=(String) parametrosInOout.get("id_usuario") ;
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");

			
			if (codRespuesta!=null && msgRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					nicknames=(String)    parametrosInOout.get("p_nickname") ;
					registro.setNickname(nicknames);
					registro.setContrasena(contrasena);
					registro.setCodRespuesta(codRespuesta);
					registro.setIdUsuario(idUsuario);
					registro.setMsgRespuesta(msgRespuesta);

				}else {
					registro.setCodRespuesta(codRespuesta);
					registro.setIdUsuario(idUsuario);
					registro.setMsgRespuesta(msgRespuesta);
				}
			}else {
				registro.setCodRespuesta("ERROR");
				registro.setIdUsuario(idUsuario);
				registro.setMsgRespuesta("No fue posible ejecutar el servicioA");
			}


		}catch (Exception e) {
			registro.setCodRespuesta("ERROR");
			registro.getIdUsuario();
			registro.setMsgRespuesta("No fue posible ejecutar el servicioB");
		}finally {
			session.close();
		}

		return registro;

	}

}
