package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.Empleador;
import com.marvic.springm6.repository.IEmpleadorRepository;
import com.marvic.springm6.service.IEmpleadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {

    IEmpleadorRepository objIEmpleadorRepository;
    /** Listar Empleadores
     * @return Lista object empleador
     */
    @Override
    public List<Empleador> listarEmpleador() {
        return objIEmpleadorRepository.findAll();
    }

    /** Crear empleador
     * @param empleador
     * @return Object Empleador
     */
    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objIEmpleadorRepository.save();
    }

    /**
     * @param idEmpleador
     * @return
     */
    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {
        return null;
    }

    /**
     * @param empleador
     * @return
     */
    @Override
    public Empleador actualizarEmpleador(Empleador empleador) {
        return null;
    }

    /**
     * @param idEmpleador
     */
    @Override
    public void eliminarEmpleadorPorId(int idEmpleador) {

    }
}
