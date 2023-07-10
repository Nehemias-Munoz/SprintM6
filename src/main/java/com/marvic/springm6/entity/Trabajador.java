package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Trabajadores")
public class Trabajador {
    @Id
    @Column(name = "id_trabajador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column
    private String email;
    //Todo: Crear relacion y FK
    @Column(name = "inst_prevision")
    private String instPrevision;
    @Column(name = "inst_salud")
    private int instSalud;
    @Column
    private long telefono;
}
