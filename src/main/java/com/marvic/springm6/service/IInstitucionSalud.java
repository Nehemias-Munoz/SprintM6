package com.marvic.springm6.service;


import com.marvic.springm6.entity.InstitucionSalud;

import java.util.List;

public interface IInstitucionSalud {
    List<InstitucionSalud> listarInstitucionSalud();
    InstitucionSalud crearInstitucionSalud(InstitucionSalud institucionSalud);
    InstitucionSalud buscarInstitucionSaludPorId(int idInstitucionSalud);
    InstitucionSalud actualizarInstitucionSalud(InstitucionSalud institucionSalud);
    void eliminarInstitucionSaludPorId(int idInstitucionSalud);
}
