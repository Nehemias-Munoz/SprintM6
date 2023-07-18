package com.marvic.springm6.service;

import com.marvic.springm6.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    List<Empleador> listarEmpleador();
    Empleador crearEmpleador(Empleador empleador);
    Empleador buscarEmpleadorPorId(int idEmpleador);
    Empleador actualizarEmpleador(int idEmpleador, Empleador empleador);
    void eliminarEmpleadorPorId(int idEmpleador);
}
