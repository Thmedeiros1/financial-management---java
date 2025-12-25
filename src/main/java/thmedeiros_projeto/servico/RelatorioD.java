package thmedeiros_projeto.servico;

import java.math.BigDecimal;
import thmedeiros_projeto.dominio.Despesa;
import thmedeiros_projeto.dominio.Ano;

public class RelatorioD {

    public BigDecimal totalDespesas(Ano ano) {
        BigDecimal total = BigDecimal.ZERO;

        for (var mov : ano.getMovimentacoes()) {
            if (mov instanceof Despesa) {
                total = total.add(mov.getValor());
            }
        }

        return total;
    }
}