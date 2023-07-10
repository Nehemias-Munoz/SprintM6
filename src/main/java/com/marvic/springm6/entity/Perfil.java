package com.marvic.springm6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @Column(name = "id_perfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    @Column
    private String descripcion;
    @Column
    private boolean estado;
}
