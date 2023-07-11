package com.marvic.springm6.service;

import com.marvic.springm6.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(int idUsuario);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuarioPorId(int idUsuario);
}
