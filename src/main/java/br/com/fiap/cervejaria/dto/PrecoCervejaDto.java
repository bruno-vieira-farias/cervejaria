package br.com.fiap.cervejaria.dto;

import java.math.BigDecimal;

public class PrecoCervejaDto {
    private BigDecimal preco;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
