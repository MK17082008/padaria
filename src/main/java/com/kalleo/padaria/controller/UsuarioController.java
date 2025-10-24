package com.kalleo.padaria.controller;

import com.kalleo.padaria.business.UsuarioService;
import com.kalleo.padaria.infrastructure.entitys.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {

        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Long id) {

        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorCpf(@RequestParam String cpf) {
        usuarioService.deletarUsuarioPorCpf(cpf);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorCpf(@RequestParam String cpf,
                                                       @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorCpf(cpf, usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

}
