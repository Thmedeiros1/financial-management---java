package thmedeiros_projeto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import thmedeiros_projeto.dominio.Ano;
import thmedeiros_projeto.dominio.Renda;
import thmedeiros_projeto.dominio.Despesa;

import thmedeiros_projeto.enums.Moeda;
import thmedeiros_projeto.enums.TipoRenda;
import thmedeiros_projeto.enums.TipoDespesa;
import thmedeiros_projeto.dominio.Movimentacao;
import thmedeiros_projeto.servico.RelatorioD;
import thmedeiros_projeto.servico.ConversorM;
import thmedeiros_projeto.servico.RelatorioProgressao;


public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Ano ano = new Ano(2025);

    boolean continuar = true;

    while (continuar) {

        System.out.println("\nDigite o tipo (1 - Renda | 2 - Despesa): ");
        int opcao = sc.nextInt();

        System.out.print("Dia: ");
        int dia = sc.nextInt();

        System.out.print("Mês: ");
        int mes = sc.nextInt();

        System.out.print("Ano: ");
        int anoDigitado = sc.nextInt();

        LocalDate data = LocalDate.of(anoDigitado, mes, dia);

        System.out.print("Valor: ");
        BigDecimal valor = sc.nextBigDecimal();

        System.out.println("Moeda (1 - REAL | 2 - DOLAR | 3 - EURO): ");
        int moedaOpcao = sc.nextInt();

        Moeda moeda;

        switch (moedaOpcao) {
            case 1 -> moeda = Moeda.REAL;
            case 2 -> moeda = Moeda.DOLAR;
            case 3 -> moeda = Moeda.EURO;
            default -> {
                System.out.println("Moeda inválida.");
                continue;
            }
        }

        if (opcao == 1) {
            System.out.println("Tipo de renda:");
            System.out.println("1 - SALARIO | 2 - FREELANCE");

            int tipo = sc.nextInt();

            TipoRenda tipoRenda =
                    (tipo == 1) ? TipoRenda.SALARIO : TipoRenda.FREELANCE;

            Renda renda = new Renda(data, valor, moeda, tipoRenda);
            ano.adicionarMovimentacao(renda);

        } else if (opcao == 2) {

            System.out.println("Tipo de despesa:");
            System.out.println("1 - ALIMENTACAO | 2 - MORADIA | 3 - TRANSPORTE");

            int tipo = sc.nextInt();

            TipoDespesa tipoDespesa;

            switch (tipo) {
                case 1 -> tipoDespesa = TipoDespesa.ALIMENTACAO;
                case 2 -> tipoDespesa = TipoDespesa.MORADIA;
                case 3 -> tipoDespesa = TipoDespesa.TRANSPORTE;
                default -> {
                    System.out.println("Tipo inválido.");
                    continue;
                }
            }

            Despesa despesa = new Despesa(data, valor, moeda, tipoDespesa);
            ano.adicionarMovimentacao(despesa);
        }

        System.out.println("\nDeseja adicionar outra movimentação? (1 - Sim | 2 - Não)");
        int resp = sc.nextInt();

        if (resp != 1) {
            continuar = false;
        }
    }

  System.out.println("\nEscolha a moeda do relatório:");
System.out.println("1 - REAL | 2 - DOLAR | 3 - EURO");
int opcaoMoedaRel = sc.nextInt();

Moeda moedaRelatorio;

switch (opcaoMoedaRel) {
    case 1 -> moedaRelatorio = Moeda.REAL;
    case 2 -> moedaRelatorio = Moeda.DOLAR;
    case 3 -> moedaRelatorio = Moeda.EURO;
    default -> moedaRelatorio = Moeda.REAL;
}

RelatorioProgressao relatorio =
        new RelatorioProgressao(moedaRelatorio);

System.out.print("Digite o mês para consulta (1-12): ");
int mesConsulta = sc.nextInt();

BigDecimal rendaMes =
        relatorio.totalRendasPorMes(ano, mesConsulta);

BigDecimal despesaMes =
        relatorio.totalDespesasPorMes(ano, mesConsulta);

System.out.println("\n--- RELATÓRIO FINANCEIRO ---");
System.out.println("Moeda: " + moedaRelatorio);
System.out.println("Total de rendas: " + rendaMes);
System.out.println("Total de despesas: " + despesaMes);
System.out.println("Saldo: " + rendaMes.subtract(despesaMes));


        sc.close();

        System.out.println("\nCadastro finalizado.");
    }

}


