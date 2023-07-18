package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.Empleador;
import com.marvic.springm6.repository.IEmpleadorRepository;
import com.marvic.springm6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {

    @Autowired
    IEmpleadorRepository objIEmpleadorRepo;
    /** Listar Empleadores
     * @return Lista object empleador
     */
    @Override
    public List<Empleador> listarEmpleador() {
        return objIEmpleadorRepo.findAll();
    }

    /** Crear empleador
     * @param empleador
     * @return Object Empleador
     */
    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objIEmpleadorRepo.save(empleador);
    }

    /** Buscar empleador por id
     * @param idEmpleador
     * @return Object Empleador
     */
    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {
        return objIEmpleadorRepo.findById(idEmpleador).orElseThrow(()-> new NoSuchElementException("Empleador no encontrado"));
    }

    /** Actualizar empleador por id
     * @param empleador
     * @return Object Empleador
     */
    @Override
    public Empleador actualizarEmpleador(int idEmpleador, Empleador empleador) {
        Empleador empleador1 = this.buscarEmpleadorPorId(idEmpleador);
        empleador1.setRun(empleador.getRun());
        empleador1.setNombre(empleador.getNombre());
        empleador1.setApellido1(empleador.getApellido1());
        empleador1.setApellido2(empleador.getApellido2());
        empleador1.setDireccion(empleador.getDireccion());
        empleador1.setEmail(empleador.getEmail());
        empleador1.setUsuario(empleador.getUsuario());
        empleador1.setTelefono(empleador.getTelefono());
        return objIEmpleadorRepo.save(empleador1);
    }

    /**Eliminar Empleador por id
     * @param idEmpleador
     */
    @Override
    public void eliminarEmpleadorPorId(int idEmpleador) {
        objIEmpleadorRepo.deleteById(idEmpleador);
    }
}
