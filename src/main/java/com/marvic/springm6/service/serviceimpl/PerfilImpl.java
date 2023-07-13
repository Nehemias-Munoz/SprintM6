package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.Perfil;
import com.marvic.springm6.repository.IPerfilRepository;
import com.marvic.springm6.service.IPerfilService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("perfilImpl")
public class PerfilImpl implements IPerfilService {

    IPerfilRepository objIPerfilRepository;
    /**Listar Perfiles
     * @return List Object perfil
     */
    @Override
    public List<Perfil> listarPerfiles() {
        return objIPerfilRepository.findAll();
    }

}
