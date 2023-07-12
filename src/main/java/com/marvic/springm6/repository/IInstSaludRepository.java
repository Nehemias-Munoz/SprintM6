package com.marvic.springm6.repository;

import com.marvic.springm6.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstSaludRepository extends JpaRepository<InstitucionSalud, Integer> {
}
