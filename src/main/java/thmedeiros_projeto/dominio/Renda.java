package thmedeiros_projeto.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.enums.TipoRenda;

public class Renda extends Movimentacao {

    private TipoRenda tipoRenda;

    public Renda(LocalDate data, BigDecimal valor, Moeda moeda, TipoRenda tipoRenda) {
        super(data, valor, moeda);
        this.tipoRenda = tipoRenda;
    }

    public TipoRenda getTipoRenda() {
        return tipoRenda;
    }
}
