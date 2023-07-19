package com.marvic.springm6.service.serviceimpl;

import com.marvic.springm6.entity.Liquidacion;
import com.marvic.springm6.repository.ILiquidacionRepository;
import com.marvic.springm6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {
    @Autowired
    ILiquidacionRepository objILiquidacionRepo;
    /**Listar usuarios
     * @return List object usuario
     */
    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objILiquidacionRepo.findAll();
    }

    /**Crear liquidaciones
     * @param liquidacion
     * @return List object liquidaciones
     */
    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objILiquidacionRepo.save(liquidacion);
    }

    /**Crear liquidacion
     * @param idLiquidacion
     * @return Object liquidacion
     */
    @Override
    public Liquidacion buscarLiquidacionPorId(long idLiquidacion) {
        return objILiquidacionRepo.findById(idLiquidacion).orElseThrow(()->new NoSuchElementException("Liquidacion no encontrada"));
    }

    /**Buscar liquidacion por id
     * @param liquidacion
     * @return Object Liquidacion
     */
    @Override
    public Liquidacion actualizarLiquidacion(long idLiquidacion,Liquidacion liquidacion) {
        Liquidacion liquidacion1 = this.buscarLiquidacionPorId(idLiquidacion);
        liquidacion1.setTrabajador(liquidacion.getTrabajador());
        liquidacion1.setPeriodo(liquidacion.getPeriodo());
        liquidacion1.setSueldoImponible(liquidacion.getSueldoImponible());
        liquidacion1.setSueldoLiquido(liquidacion.getSueldoLiquido());
        liquidacion1.setInstSalud(liquidacion.getInstSalud());
        liquidacion1.setMontoInstSalud(liquidacion.getMontoInstSalud());
        liquidacion1.setInstPrevisional(liquidacion.getInstPrevisional());
        liquidacion1.setMontoInstPrevisional(liquidacion.getMontoInstPrevisional());
        liquidacion1.setTotalDescuento(liquidacion.getTotalDescuento());
        liquidacion1.setTotalHaberes(liquidacion.getTotalHaberes());
        liquidacion1.setAnticipo(liquidacion.getAnticipo());
        return objILiquidacionRepo.save(liquidacion1);
    }

    /**Eliminar liquidacion por id
     * @param idLiquidacion
     */
    @Override
    public void eliminarLiquidacionPorId(long idLiquidacion) {
        objILiquidacionRepo.deleteById(idLiquidacion);
    }
}
