package com.marvic.springm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Institucion_Prevision")
public class InstitucionPrevision {
    @Id
    @Column(name = "id_inst_prevision")
    private int idInstPrevision;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private float porcDcto;
    @JsonIgnore
    @OneToMany(mappedBy = "instPrevision")
    List<Trabajador> listaTrabajadores;
    @JsonIgnore
    @OneToMany(mappedBy = "instPrevisional")
    List<Liquidacion> listaLiquidaciones;


}
