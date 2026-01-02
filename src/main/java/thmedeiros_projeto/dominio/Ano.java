package thmedeiros_projeto.dominio;

import java.util.ArrayList;
import java.util.List;

public class Ano {

    private int ano;
    private List<Movimentacao> movimentacoes;

    public Ano(int ano) {
        this.ano = ano;
        this.movimentacoes = new ArrayList<>();
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public int getAno() {
        return ano;
    }

    public List<Movimentacao> getMovimentacoes() {
        return List.copyOf(movimentacoes);
    }
}

