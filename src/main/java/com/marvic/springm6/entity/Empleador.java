package com.marvic.springm6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Empleador")
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
    //Relacion usuario
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;
    @Column
    private long telefono;
    //Relacion tabla intermedia
//    @ManyToMany
//    @JoinTable(name = "Empl_Trab",
//            joinColumns = @JoinColumn(name = "id_empleador", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "id_trabajador", nullable = false))
    @JsonIgnore
    @ManyToMany(mappedBy = "listaEmpleadores",cascade = CascadeType.ALL)
    private List<Trabajador> listaTrabajadores;

}
