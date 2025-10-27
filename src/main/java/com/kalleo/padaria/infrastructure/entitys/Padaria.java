package com.kalleo.padaria.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_padaria")
public class Padaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "nome")
    private String nome;


    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Column(name = "preco")
    private Double preco;


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name = "quantidade")
    private Integer quantidade;

}
