package com.marvic.springm6.service;

import com.marvic.springm6.entity.Perfil;

import java.util.List;

public interface IPerfilService {
    List<Perfil> listarPerfiles();
    Perfil crearPerfil(Perfil perfil);
    Perfil buscarPerfilPorId(int idPerfil);
    Perfil actualizarPerfil(Perfil perfil);
    void eliminarPerfilPorId(int idPerfil);
}
