package com.krakedev.videojuegos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakedev.videojuegos.entidades.Videojuego;

@Service
public class ServicioVideojuegoJdbc {

    private VideojuegoJdbc jdbc =
            new VideojuegoJdbc();

    public Videojuego crear(Videojuego v) {
        return jdbc.insertar(v);
    }

    public List<Videojuego> listar() {
        return jdbc.listar();
    }

    public Videojuego buscarPorCodigo(String codigo) {
        return jdbc.buscar(codigo);
    }

    public Videojuego actualizar(
            String codigo,
            Videojuego v) {

        return jdbc.actualizar(codigo, v);
    }

    public boolean eliminar(String codigo) {
        return jdbc.eliminar(codigo);
    }
}