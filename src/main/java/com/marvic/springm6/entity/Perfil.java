package com.marvic.springm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @Column(name = "id_perfil")
    private int idPerfil;
    @Column
    private String descripcion;
    @Column
    private boolean estado;
    @JsonIgnore
    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;
}
