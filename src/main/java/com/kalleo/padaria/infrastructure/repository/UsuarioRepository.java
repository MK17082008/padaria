package com.kalleo.padaria.infrastructure.repository;

import com.kalleo.padaria.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);

}
