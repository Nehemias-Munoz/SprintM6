package com.marvic.springm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "Usuario")
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
    // Relacion usuario-perfil
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfil perfil;
    @Column
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;
    // Relacion usuario-empleador
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    List<Empleador> listaEmpleador;
}
