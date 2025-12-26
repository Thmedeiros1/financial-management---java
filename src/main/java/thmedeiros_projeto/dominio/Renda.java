package thmedeiros_projeto.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.enums.TipoRenda;

public class Renda extends Movimentacao {

    private TipoRenda tipo;

    public Renda(LocalDate data, BigDecimal valor, Moeda moeda, TipoRenda tipo) {
        super(data, valor, moeda);
        this.tipo = tipo;
    }

    public TipoRenda getTipo() {
        return tipo;
    }
}
