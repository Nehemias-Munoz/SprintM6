package com.marvic.springm6.controller;

import com.marvic.springm6.entity.Trabajador;
import com.marvic.springm6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    ITrabajadorService objITrabajadorService;

    @GetMapping
    public String listarTrabajadors(Model model) {
        List<Trabajador> listaTrabajadores = objITrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", listaTrabajadores);
        return "listarTrabajadores";
    }

    @PostMapping("/crearTrabajador")
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador){
        return objITrabajadorService.crearTrabajador(trabajador);
    }


    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajador = objITrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador",trabajador);
        return "trabajador";
    }


    @PutMapping
    public Trabajador actualizarTrabajador(@RequestBody Trabajador trabajador) {
        return objITrabajadorService.actualizarTrabajador(trabajador);
    }


    @DeleteMapping("/{idTrabajador}")
    public void eliminarTrabajadorPorId(@PathVariable int idTrabajador) {objITrabajadorService.eliminarTrabajadorPorId(idTrabajador);}

}
