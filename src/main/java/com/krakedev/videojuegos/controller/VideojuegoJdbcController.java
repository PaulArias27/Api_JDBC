package com.krakedev.videojuegos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.krakedev.videojuegos.services.ServicioVideojuegoJdbc;
import com.krakedev.videojuegos.entidades.Videojuego;

@RestController
@RequestMapping("/jdbc/videojuegos")
public class VideojuegoJdbcController {

    @Autowired
    private ServicioVideojuegoJdbc servicio;

    @PostMapping
    public Videojuego crear(
            @RequestBody Videojuego videojuego) {

        return servicio.crear(videojuego);
    }

    @GetMapping
    public List<Videojuego> listar() {

        return servicio.listar();
    }

    @GetMapping("/{codigo}")
    public Videojuego buscar(
            @PathVariable String codigo) {

        return servicio.buscarPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public Videojuego actualizar(
            @PathVariable String codigo,
            @RequestBody Videojuego videojuego) {

        return servicio.actualizar(
                codigo,
                videojuego);
    }

    @DeleteMapping("/{codigo}")
    public boolean eliminar(
            @PathVariable String codigo) {

        return servicio.eliminar(codigo);
    }
}