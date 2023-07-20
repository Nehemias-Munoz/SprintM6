package com.marvic.springm6.controller;

import com.marvic.springm6.entity.Usuario;
import com.marvic.springm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objIUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario() {
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        usuario.setFechaCreacion(LocalDateTime.now());
        //Todo: si se crea como empleador lo registramos en su tabla
        //Añadir campo en registro usuario para verificar si seran los mismos datos
        objIUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/{idUsuario}")
    public String buscarUsuarioPorId(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objIUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model) {
        model.addAttribute("usuario", objIUsuarioService.buscarUsuarioPorId(idUsuario));
        return "editarUsuario";
    }

    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, @PathVariable int idUsuario) {
        usuario.setFechaCreacion(LocalDateTime.now());
        objIUsuarioService.actualizarUsuario(idUsuario, usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objIUsuarioService.eliminarUsuarioPorId(idUsuario);
        return "redirect:/usuario";
    }
}
