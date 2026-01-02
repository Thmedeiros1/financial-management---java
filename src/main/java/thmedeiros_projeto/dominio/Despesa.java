package thmedeiros_projeto.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.enums.TipoDespesa;

public class Despesa extends Movimentacao {

    private TipoDespesa tipoDespesa;

    public Despesa(LocalDate data, BigDecimal valor, Moeda moeda, TipoDespesa tipoDespesa) {
        super(data, valor, moeda);
        this.tipoDespesa = tipoDespesa;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }
}


