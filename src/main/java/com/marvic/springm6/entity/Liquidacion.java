package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Liquidacion")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion")
    private long idLiquidacion;
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Column
    private LocalDate periodo;
    @Column(name = "sueldo_imponible")
    private int sueldoImponible;
    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;
    @Column(name = "id_inst_salud")
    private int idInstSalud;
    @Column(name = "monto_inst_salud")
    private int montoInstSalud;
    @Column(name = "id_inst_previsional")
    private int idInstPrevisional;
    @Column(name = "monto_inst_previsional")
    private int montoInstPrevisional;
    @Column(name = "total_descuento")
    private int totalDescuento;
    @Column(name = "total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;
}
