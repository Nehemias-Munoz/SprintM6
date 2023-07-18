package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.Trabajador;
import com.marvic.springm6.repository.ITrabajadorRepository;
import com.marvic.springm6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("/usuarioImpl")
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepository objTrabajadorRepo;
    /**Listar trabajdores
     * @return Lista de obj trabajadores
     */
    @Override
    public List<Trabajador> listarTrabajadores() {
        return objTrabajadorRepo.findAll();
    }

    /**Crear trabajador
     * @param trabajador
     * @return Object trabajador
     */
    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepo.save(trabajador);
    }

    /**Buscar trabajador por id
     * @param idTrabajador
     * @return Object trabajador
     */
    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(()-> new NoSuchElementException("Trabajador no encontrado"));
    }

    /**Actualizar trabajadores por id
     * @param trabajador
     * @return Object trabjador
     */
    @Override
    public Trabajador actualizarTrabajador(int idTrabajador,Trabajador trabajador) {
        Trabajador trabajador1 = this.buscarTrabajadorPorId(idTrabajador);
        trabajador1.setNombre(trabajador.getNombre());
        trabajador1.setApellido1(trabajador.getApellido1());
        trabajador1.setApellido2(trabajador.getApellido2());
        trabajador1.setRun(trabajador.getRun());
        trabajador1.setEmail(trabajador.getEmail());
        trabajador1.setInstPrevision(trabajador.getInstPrevision());
        trabajador1.setInstSalud(trabajador.getInstSalud());
        trabajador1.setTelefono(trabajador.getTelefono());
        return objTrabajadorRepo.save(trabajador1);
    }

    /** Eliminar Trabajador por id
     * @param idTrabajador
     */
    @Override
    public void eliminarTrabajadorPorId(int idTrabajador) {
        objTrabajadorRepo.deleteById(idTrabajador);
    }
}
