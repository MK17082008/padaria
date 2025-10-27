package com.kalleo.padaria.infrastructure.repository;

import com.kalleo.padaria.infrastructure.entitys.Padaria;
import com.kalleo.padaria.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadariaRepository extends JpaRepository<Padaria, Long> {

}
