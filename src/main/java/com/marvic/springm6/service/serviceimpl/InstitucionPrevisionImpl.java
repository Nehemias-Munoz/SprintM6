package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.InstitucionPrevision;
import com.marvic.springm6.repository.IInstPrevisionRepository;
import com.marvic.springm6.service.IInstitucionPrevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("institucionPrevisionImpl")
public class InstitucionPrevisionImpl implements IInstitucionPrevision {
    @Autowired
    IInstPrevisionRepository objIInstPrevisionRepository;
    /**Listar instituciones
     * @return List object instituciones previsionales
     */
    @Override
    public List<InstitucionPrevision> listarInstitucionPrevision() {
        return objIInstPrevisionRepository.findAll();
    }
}
