package com.marvic.springm6.service;

import com.marvic.springm6.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    List<Liquidacion> listarLiquidaciones();
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    Liquidacion buscarLiquidacionPorId(long idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion);
    void eliminarLiquidacionPorId(long idLiquidacion);
}
