package thmedeiros_projeto.servico;

import java.math.BigDecimal;

import thmedeiros_projeto.dominio.Ano;
import thmedeiros_projeto.dominio.Movimentacao;
import thmedeiros_projeto.dominio.Renda;
import thmedeiros_projeto.dominio.Despesa;
import thmedeiros_projeto.enums.Moeda;

public class RelatorioProgressao {

    private Moeda moedaPadrao;

    public RelatorioProgressao(Moeda moedaPadrao) {
        this.moedaPadrao = moedaPadrao;
    }

    public BigDecimal totalRendasPorMes(Ano ano, int mes) {
        BigDecimal total = BigDecimal.ZERO;

        for (Movimentacao mov : ano.getMovimentacoes()) {
            if (mov instanceof Renda && mov.getData().getMonthValue() == mes) {
                total = total.add(mov.getValorConvertido(moedaPadrao));
            }
        }
        return total;
    }

    public BigDecimal totalDespesasPorMes(Ano ano, int mes) {
        BigDecimal total = BigDecimal.ZERO;

        for (Movimentacao mov : ano.getMovimentacoes()) {
            if (mov instanceof Despesa && mov.getData().getMonthValue() == mes) {
                total = total.add(mov.getValorConvertido(moedaPadrao));
            }
        }
        return total;
    }

    public void relatorioDiario(Ano ano, int mes) {
        System.out.println("\n=== RELATÓRIO DIÁRIO ===");

        for (Movimentacao mov : ano.getMovimentacoes()) {
            if (mov.getData().getMonthValue() == mes) {
                System.out.println(
                    mov.getData() + " - " +
                    mov.getValorConvertido(moedaPadrao) + " " +
                    moedaPadrao
                );
            }
        }
    }
}




