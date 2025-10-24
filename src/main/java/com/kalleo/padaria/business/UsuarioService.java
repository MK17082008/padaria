package com.kalleo.padaria.business;

import com.kalleo.padaria.infrastructure.entitys.Usuario;
import com.kalleo.padaria.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("CPF não encontrado"));
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não encontrado"));
    }

    public void deletarUsuarioPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }

    public void atualizarUsuarioPorCpf(String cpf, Usuario usuario) {
        Usuario usuarioEntity = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getNome() != null) {
            usuarioEntity.setNome(usuario.getNome());
        }

        if (usuario.getEmail() != null) {
            usuarioEntity.setEmail(usuario.getEmail());
        }

        if (usuario.getTelefone() != null) {
            usuarioEntity.setTelefone(usuario.getTelefone());
        }

        if (usuario.getDataNascimento() != null) {
            usuarioEntity.setDataNascimento(usuario.getDataNascimento());
        }

        repository.save(usuarioEntity);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}
