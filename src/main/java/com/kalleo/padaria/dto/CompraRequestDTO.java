package com.kalleo.padaria.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;;

@Getter
@Setter
@Data
public class CompraRequestDTO {


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    private Long usuarioId;

    public List<Long> getProdutosIds() {
        return produtosIds;
    }

    public void setProdutosIds(List<Long> produtosIds) {
        this.produtosIds = produtosIds;
    }

    private List<Long> produtosIds;


}
