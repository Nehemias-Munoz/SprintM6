package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.InstitucionSalud;
import com.marvic.springm6.repository.IInstSaludRepository;
import com.marvic.springm6.service.IInstitucionSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("institucionSaludImp")
public class InstitucionSaludImpl implements IInstitucionSalud {
    @Autowired
    IInstSaludRepository objIInstSaludRepository;
    /**Listar instituciones
     * @return List object instituciones de salud
     */
    @Override
    public List<InstitucionSalud> listarInstitucionSalud() {
        return objIInstSaludRepository.findAll();
    }

}
