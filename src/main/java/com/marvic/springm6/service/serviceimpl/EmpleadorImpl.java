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
        return objIEmpleadorRepository.save(empleador);
    }

    /** Buscar empleador por id
     * @param idEmpleador
     * @return Object Empleador
     */
    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {
        return null;
    }

    /** Actualizar empleador por id
     * @param empleador
     * @return Object Empleador
     */
    @Override
    public Empleador actualizarEmpleador(Empleador empleador) {
        Empleador empleador1 = this.buscarEmpleadorPorId(empleador.getIdEmpleador());
        empleador1.setRun(empleador.getRun());
        empleador1.setNombre(empleador.getNombre());
        empleador1.setApellido1(empleador.getApellido1());
        empleador1.setApellido2(empleador.getApellido2());
        empleador1.setDireccion(empleador.getDireccion());
        empleador1.setEmail(empleador.getEmail());
        empleador1.setUsuario(empleador.getUsuario());
        empleador1.setTelefono(empleador.getTelefono());
        return objIEmpleadorRepository.save(empleador1);
    }

    /**Eliminar Empleador por id
     * @param idEmpleador
     */
    @Override
    public void eliminarEmpleadorPorId(int idEmpleador) {
        objIEmpleadorRepository.deleteById(idEmpleador);
    }
}
