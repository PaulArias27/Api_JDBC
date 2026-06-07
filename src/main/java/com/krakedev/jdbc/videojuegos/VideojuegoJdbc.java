package com.krakedev.jdbc.videojuegos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.jdbc.Conexion;
import com.krakedev.videojuegos.entidades.Videojuego;

public class VideojuegoJdbc {

    private static final Logger logger =
            LogManager.getLogger(VideojuegoJdbc.class);

    public Videojuego insertar(Videojuego v) {

        Connection con = null;

        try {

            con = Conexion.getConnection();

            String sql =
                "INSERT INTO videojuegos VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, v.getCodigo());
            ps.setString(2, v.getNombre());
            ps.setString(3, v.getPlataforma());
            ps.setDouble(4, v.getPrecio());
            ps.setBoolean(5, v.isDisponible());
            ps.setString(6, v.getGenero());

            ps.executeUpdate();

            logger.info("Videojuego insertado");

            return v;

        } catch (Exception e) {

            logger.error("Error insertando", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return null;
    }

    public List<Videojuego> listar() {

        List<Videojuego> lista =
                new ArrayList<>();

        Connection con = null;

        try {

            con = Conexion.getConnection();

            String sql =
                    "SELECT * FROM videojuegos";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Videojuego v =
                        new Videojuego();

                v.setCodigo(rs.getString("codigo"));
                v.setNombre(rs.getString("nombre"));
                v.setPlataforma(rs.getString("plataforma"));
                v.setPrecio(rs.getDouble("precio"));
                v.setDisponible(rs.getBoolean("disponible"));
                v.setGenero(rs.getString("genero"));

                lista.add(v);
            }

        } catch (Exception e) {

            logger.error("Error listando", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return lista;
    }

    public Videojuego buscar(String codigo) {

        Connection con = null;

        try {

            con = Conexion.getConnection();

            String sql =
                "SELECT * FROM videojuegos WHERE codigo=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, codigo);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return new Videojuego(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("plataforma"),
                        rs.getDouble("precio"),
                        rs.getBoolean("disponible"),
                        rs.getString("genero"));
            }

        } catch (Exception e) {

            logger.error("Error buscando", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return null;
    }

    public Videojuego actualizar(
            String codigo,
            Videojuego v) {

        Connection con = null;

        try {

            con = Conexion.getConnection();

            String sql =
                "UPDATE videojuegos SET nombre=?, plataforma=?, precio=?, disponible=?, genero=? WHERE codigo=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, v.getNombre());
            ps.setString(2, v.getPlataforma());
            ps.setDouble(3, v.getPrecio());
            ps.setBoolean(4, v.isDisponible());
            ps.setString(5, v.getGenero());
            ps.setString(6, codigo);

            ps.executeUpdate();

            logger.info("Videojuego actualizado");

            return buscar(codigo);

        } catch (Exception e) {

            logger.error("Error al actualizar", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return null;
    }

    public boolean eliminar(String codigo) {

        Connection con = null;

        try {

            con = Conexion.getConnection();

            String sql =
                    "DELETE FROM videojuegos WHERE codigo=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, codigo);

            int filas =
                    ps.executeUpdate();

            logger.info("Videojuego eliminado");

            return filas > 0;

        } catch (Exception e) {

            logger.error("Error al eliminar", e);

        } finally {

            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return false;
    }
}