package thmedeiros_projeto.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.dominio.TipoDespesa;

public class Despesa extends Movimentacao {

    private TipoDespesa tipo;

    public Despesa(LocalDate data, BigDecimal valor, Moeda moeda, TipoDespesa tipo) {
        super(data, valor, moeda);
        this.tipo = tipo;
    }

    public TipoDespesa getTipo() {
        return tipo;
    }
}

public enum TipoDespesa {
    ALIMENTACAO,
    TRANSPORTE,
    MORADIA,
    SAUDE,
    EDUCACAO,
    LAZER,
    OUTROS
}