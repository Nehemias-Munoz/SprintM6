package com.marvic.springm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Institucion_Salud")
public class InstitucionSalud {
    @Id
    @Column(name = "id_inst_salud")
    private int idInstSalud;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private float porcDcto;
    //Relacion inst. salud - trabajador
    @JsonIgnore
    @OneToMany(mappedBy = "instSalud")
    List<Trabajador> listaTrabajadores;
    //Relacion inst. salud - liquidacion
    @JsonIgnore
    @OneToMany(mappedBy = "instSalud")
    List<Liquidacion> listaLiquidaciones;

}
