package thmedeiros_projeto.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;

import thmedeiros_projeto.enums.Moeda;

public class ConversorM {

    private static final BigDecimal TAXA_DOLAR = new BigDecimal("5.00");
    private static final BigDecimal TAXA_EURO  = new BigDecimal("5.50");

    public static BigDecimal converter(
            BigDecimal valor,
            Moeda moedaOrigem,
            Moeda moedaDestino) {

        if (moedaOrigem == moedaDestino) {
            return valor.setScale(2, RoundingMode.HALF_UP);
        }

        BigDecimal valorEmReal = converterParaReal(valor, moedaOrigem);
        return converterDeReal(valorEmReal, moedaDestino);
    }

    private static BigDecimal converterParaReal(BigDecimal valor, Moeda moeda) {

        switch (moeda) {
            case REAL:
                return valor;
            case DOLAR:
                return valor.multiply(TAXA_DOLAR);
            case EURO:
                return valor.multiply(TAXA_EURO);
            default:
                throw new IllegalArgumentException("Moeda inválida");
        }
    }

    private static BigDecimal converterDeReal(BigDecimal valor, Moeda moeda) {

        switch (moeda) {
            case REAL:
                return valor.setScale(2, RoundingMode.HALF_UP);
            case DOLAR:
                return valor.divide(TAXA_DOLAR, 2, RoundingMode.HALF_UP);
            case EURO:
                return valor.divide(TAXA_EURO, 2, RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("Moeda inválida");
        }
    }
}

