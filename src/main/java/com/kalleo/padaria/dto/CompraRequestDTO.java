package com.kalleo.padaria.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Data
public class CompraRequestDTO {
    private Long usuarioId;
    private List<Long> produtosIds;
}
