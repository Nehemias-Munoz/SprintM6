package com.marvic.springm6.service;

import com.marvic.springm6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    List<Trabajador> listarTrabajadores();
    Trabajador crearTrabajador(Trabajador trabajador);
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    Trabajador actualizarTrabajador(int idTrabajador, Trabajador trabajador);
    void eliminarTrabajadorPorId(int idTrabajador);
}
