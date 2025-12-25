package thmedeiros_projeto;

import java.math.BigDecimal;
import java.time.LocalDate;

import thmedeiros_projeto.dominio.Ano;
import thmedeiros_projeto.dominio.Renda;
import thmedeiros_projeto.dominio.Despesa;

import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.enums.TipoRenda;
import thmedeiros_projeto.enums.TipoDespesa;

import thmedeiros_projeto.servico.RelatorioD;

public class Main {
    public static void main(String[] args) {
        Moeda minhaMoeda = Moeda.DOLAR;
        System.out.println("Minha moeda selecionada é: " + minhaMoeda);
    }
}