package com.marvic.springm6.controller;

import com.marvic.springm6.entity.Empleador;
import com.marvic.springm6.service.IEmpleadorService;
import com.marvic.springm6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService objIEmpleadorService;

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping
    public String listarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objIEmpleadorService.listarEmpleador();
        model.addAttribute("empleadores",listaEmpleadores);
        return "listarEmpleadores";
    }
//Todo: mantener comentado mientras no haya sesion
//    @GetMapping("/crearEmpleador")
//    public String mostrarFormularioCrearEmpleador(){
//        return "crearEmpleador";
//    }

    @GetMapping("/crearEmpleador")
    public String mostrarFormularioCrearEmpleador(Model model){
        model.addAttribute("usuarios", objIUsuarioService.listarUsuarios());
        return "crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador){
        objIEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador";
    }

    @GetMapping("/{idEmpleador}")
    public String buscarEmpleadorPorId(@PathVariable int idEmpleador, Model model){
        Empleador empleador = objIEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador",empleador);
        return "redirect:/empleador";
    }

    @PostMapping("/editar/{idEmpleador}")
    public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
        model.addAttribute("empleador", objIEmpleadorService.buscarEmpleadorPorId(idEmpleador));
        model.addAttribute("usuarios", objIUsuarioService.listarUsuarios());
        return "editarEmpleador";
    }

    @PostMapping("/actualizar/{idEmpleador}")
    public String actualizarEmpleador(@ModelAttribute Empleador empleador, @PathVariable int idEmpleador){
        objIEmpleadorService.actualizarEmpleador(idEmpleador,empleador);
        return "redirect:/empleador";
    }

    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleadorPorId(@PathVariable int idEmpleador){
        objIEmpleadorService.eliminarEmpleadorPorId(idEmpleador);
        return "redirect:/empleador";
    }
}
