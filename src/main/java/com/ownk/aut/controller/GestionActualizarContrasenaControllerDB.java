package com.ownk.aut.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.aut.model.ActualizarContrasena;
import com.ownk.aut.model.IngresoUsuarios;
import com.ownk.aut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.aut.persistencia.dao.Actualizar;
import com.ownk.aut.persistencia.dao.Ingreso;

public class GestionActualizarContrasenaControllerDB {
		
	public ActualizarContrasena actualizar(String nickname, String contrasena, String contrasenaNueva) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		ActualizarContrasena actualizarContrasena = new ActualizarContrasena();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Actualizar dao = null;
		String codRespuesta;
		String msgRespuesta;
		String nicknames;

		/*
		 * ==============================================
		 * Se obtiene la session de la conexion JDBC con el
		 * framework de persistencia de la fabrica
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
			dao = session.getMapper(Actualizar.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			
			parametrosInOout.put("p_nickname",nickname );
			parametrosInOout.put("p_contrasena", contrasena);
			parametrosInOout.put("p_contrasenanueva", contrasenaNueva);
			parametrosInOout.put("cod_respuesta",null );
			parametrosInOout.put("msg_respuesta", null);

			dao.actualizar(parametrosInOout);
			
			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");

			
			if (codRespuesta!=null && msgRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					nicknames=(String)    parametrosInOout.get("p_nickname") ;
					actualizarContrasena.setNickname(nicknames);
					actualizarContrasena.setContrasena(contrasena);
					actualizarContrasena.setContrasena(contrasenaNueva);
					actualizarContrasena.setCodRespuesta(codRespuesta);
					actualizarContrasena.setMsgRespuesta(msgRespuesta);

				}else {
					actualizarContrasena.setCodRespuesta(codRespuesta);
					actualizarContrasena.setMsgRespuesta(msgRespuesta);
				}
			}else {
				actualizarContrasena.setCodRespuesta("ERROR");
				actualizarContrasena.setMsgRespuesta("No fue posible ejecutar el servicioA");
			}


		}catch (Exception e) {
			actualizarContrasena.setCodRespuesta("ERROR");
			actualizarContrasena.setMsgRespuesta("No fue posible ejecutar el servicioB");
		}finally {
			session.close();
		}

		return actualizarContrasena;

	}
}
