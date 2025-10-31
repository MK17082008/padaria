package com.kalleo.padaria.controller;


import com.kalleo.padaria.business.CompraService;
import com.kalleo.padaria.dto.CompraRequestDTO;
import com.kalleo.padaria.infrastructure.entitys.Compra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraRequestDTO dto) {
        Compra compraCriada = compraService.criarCompraComDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraCriada);
    }
}

