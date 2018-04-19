package com.ownk.aut.persistencia.configuracion;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManagerMyBatisApp {

	private static SqlSessionFactory sqlSessionFactory;



	public static Boolean initConfiguration() {
		try {
			String resource = "mybatis-config-oracle-app.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			return true;


		} catch (Exception e) {
		
			e.printStackTrace();

			return false;
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static SqlSession openSession() {


		try {
			return sqlSessionFactory.openSession();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return null;

	}

	public static SqlSession openSessionAutoCommit() {

		try {
			return sqlSessionFactory.openSession(true);
		}catch (Exception e) {
			
			e.printStackTrace();
		}

		return null;

	}



}

