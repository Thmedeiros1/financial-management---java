package thmedeiros_projeto.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import thmedeiros_projeto.enums.Moeda;

public abstract class Movimentacao {
    protected LocalDate data;
    protected BigDecimal valor;
    protected Moeda moeda;

    public Movimentacao(LocalDate data, BigDecimal valor, Moeda moeda) {
        this.data = data;
        this.valor = valor;
        this.moeda = moeda;
    }
    
    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public LocalDate getData() {
        return data;
    }
}