package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column
    private int run;
    @Column
    private int clave;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column(name = "id_perfil")
    //Todo: Crear relacion y FK
    private int idPerfil;
    @Column
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column
    private long telefono;
}
