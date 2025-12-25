package thmedeiros_projeto.dominio;

import java.util.List;

public class Mes {
    private Month mes;
    private List<Dia> dias;
    private Lista<Movimentacao> movimentacoes;

    public Mes(Month mes, int quantidadeDias, Ano ano) {
        this.mes = mes;
        this.dias = Dia.criarDias(this, quantidadeDias);
        this.movimentacoes = new ArrayList<>();
    }
}