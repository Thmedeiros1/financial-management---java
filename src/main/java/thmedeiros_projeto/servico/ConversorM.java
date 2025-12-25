package thmedeiros_projeto.servico;

import java.math.BigDecimal;
import thmedeiros_projeto.enums.Moeda;

public class ConversorM {

    public static BigDecimal converter(BigDecimal valor, Moeda origem, Moeda destino) {

        if (origem == destino) {
            return valor;
        }

        if (origem == Moeda.DOLAR && destino == Moeda.REAL) {
            return valor.multiply(new BigDecimal("5.0"));
        }

        if (origem == Moeda.REAL && destino == Moeda.DOLAR) {
            return valor.divide(new BigDecimal("5.0"));
        }

        return valor;
    }
}