package com.krakedev.apijdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.jdbc.Conexion;

public class TestConexion {

    private static final Logger logger =
            LogManager.getLogger(TestConexion.class);

    public static void main(String[] args) {

        Connection con = null;

        try {

            logger.info("Intentando conectar a PostgreSQL...");

            con = Conexion.getConnection();

            if (con != null) {

                logger.info("Conexión exitosa a PostgreSQL");

            } else {

                logger.error("No se pudo establecer la conexión");
            }

        } catch (Exception e) {

            logger.error("Error durante la prueba de conexión", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            logger.info("Conexión cerrada");
        }
    }
}
