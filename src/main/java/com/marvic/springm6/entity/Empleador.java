package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Empleadores")
public class Empleador {
    @Id
    @Column(name = "id_empleador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column
    private String direccion;
    @Column
    private String email;
    @Column(name = "id_usuario")
    //Todo: Crear relacion y FK
    private int idUsuario;
    @Column
    private long telefono;
}
