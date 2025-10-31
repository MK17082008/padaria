package com.kalleo.padaria.business;

import com.kalleo.padaria.dto.CompraRequestDTO;
import com.kalleo.padaria.infrastructure.entitys.Compra;
import com.kalleo.padaria.infrastructure.entitys.Padaria;
import com.kalleo.padaria.infrastructure.entitys.Usuario;
import com.kalleo.padaria.infrastructure.repository.CompraRepository;
import com.kalleo.padaria.infrastructure.repository.PadariaRepository;
import com.kalleo.padaria.infrastructure.repository.UsuarioRepository;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final PadariaRepository padariaRepository;

    public Compra criarCompraComDTO(CompraRequestDTO dto) {
        // Corrigido: use getUsuarioId() se o DTO tiver esse método
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Corrigido: use getProdutosIds() se o DTO tiver esse método
        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra
                .builder()
                .usuario(usuario)
                .produtos(produtos)
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();

        return compraRepository.save(compra);
    }

    private Double calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream()
                .mapToDouble(p -> p.getPreco() != null ? p.getPreco() : 0.0)
                .sum();
    }
}
