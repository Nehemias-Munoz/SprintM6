package com.marvic.springm6.service;

import com.marvic.springm6.entity.InstitucionPrevision;

import java.util.List;

public interface IInstitucionPrevision {
    List<InstitucionPrevision> listarInstitucionPrevision();
    InstitucionPrevision crearInstitucionPrevision(InstitucionPrevision institucionPrevision);
    InstitucionPrevision buscarInstitucionPrevisionPorId(int idInstitucionPrevision);
    InstitucionPrevision actualizarInstitucionPrevision(InstitucionPrevision institucionPrevision);
    void eliminarInstitucionPrevisionPorId(int idInstitucionPrevision);
}
