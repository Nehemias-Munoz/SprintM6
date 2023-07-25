package com.marvic.springm6.restcontroller;

import com.marvic.springm6.entity.Usuario;
import com.marvic.springm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
         return objIUsuarioService.listarUsuarios();
    }

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objIUsuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario) {
        return objIUsuarioService.buscarUsuarioPorId(idUsuario);
    }

    @PostMapping("/actualizar/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable int idUsuario) {
        return objIUsuarioService.actualizarUsuario(idUsuario,usuario);
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public void eliminarUsuarioPorId(@PathVariable int idUsuario) {objIUsuarioService.eliminarUsuarioPorId(idUsuario);}

}
