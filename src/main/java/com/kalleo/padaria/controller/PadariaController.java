package com.kalleo.padaria.controller;

import com.kalleo.padaria.business.PadariaService;
import com.kalleo.padaria.infrastructure.entitys.Padaria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/padaria")
@RequiredArgsConstructor
public class PadariaController {

    public PadariaController(PadariaService padariaService) {
        this.padariaService = padariaService;
    }

    private final PadariaService padariaService;

    // Criar nova padaria
    @PostMapping
    public ResponseEntity<Padaria> salvar(@RequestBody Padaria padaria) {
        padariaService.salvarPadaria(padaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(padaria);
    }

    // Buscar padaria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Padaria> buscarPorId(@PathVariable Long id) {
        Padaria padaria = padariaService.buscarPorId(id);
        return ResponseEntity.ok(padaria);
    }

    // Listar todas as padarias
    @GetMapping
    public ResponseEntity<List<Padaria>> listarTodos() {
        List<Padaria> padarias = padariaService.listarTodos();
        return ResponseEntity.ok(padarias);
    }

    // Atualizar padaria existente
    @PutMapping("/{id}")
    public ResponseEntity<Padaria> atualizar(@PathVariable Long id, @RequestBody Padaria novaPadaria) {
        padariaService.atualizarPadaria(id, novaPadaria);
        return ResponseEntity.ok(novaPadaria);
    }

    // Deletar padaria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        padariaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
