package com.kalleo.padaria.business;

import com.kalleo.padaria.infrastructure.entitys.Padaria;
import com.kalleo.padaria.infrastructure.repository.PadariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PadariaService {


    public PadariaService(PadariaRepository padariaRepository) {
        this.padariaRepository = padariaRepository;
    }

    private final PadariaRepository padariaRepository;

    // Salvar nova padaria
    public void salvarPadaria(Padaria padaria) {
        padariaRepository.save(padaria);
    }

    // Buscar padaria por ID
    public Padaria buscarPorId(Long id) {
        return padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria não encontrado com Id: " + id));
    }

    // Listar todas as padarias
    public List<Padaria> listarTodos() {
        return padariaRepository.findAll();
    }

    // Atualizar padaria existente
    public void atualizarPadaria(Long id, Padaria novaPadaria) {
        Padaria existente = padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria não encontrado com Id: " + id));

        existente.setNome(novaPadaria.getNome());
        existente.setPreco(novaPadaria.getPreco());
        existente.setQuantidade(novaPadaria.getQuantidade());

        padariaRepository.save(existente);
    }

    // Deletar padaria por ID
    public void deletarPorId(Long id) {
        if (!padariaRepository.existsById(id)) {
            throw new RuntimeException("Item de padaria não encontrado com Id: " + id);
        }
        padariaRepository.deleteById(id);
    }
}
