package com.marvic.springm6.repository;

import com.marvic.springm6.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadorRepository extends JpaRepository<Empleador,Integer> {
}
