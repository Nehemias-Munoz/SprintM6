package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
