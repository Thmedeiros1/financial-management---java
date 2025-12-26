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

import thmedeiros_projeto.servico.RelatorioProgressao;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ano ano = new Ano(2025);

        boolean continuar = true;

        System.out.println("=== CONTROLE FINANCEIRO ===");

        while (continuar) {

            System.out.println("\n1 - Cadastrar Renda");
            System.out.println("2 - Cadastrar Despesa");
            System.out.println("3 - Ver Relatório Mensal");
            System.out.println("4 - Ver Relatório Diário");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            int opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarRenda(sc, ano);
                    break;

                case 2:
                    cadastrarDespesa(sc, ano);
                    break;

                case 3:
                    exibirRelatorio(sc, ano);
                    break;

                case 4:
                    exibirRelatorioDiario(sc, ano);
                    break;

                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }

    // MÉTODOS AUXILIARES

    private static LocalDate lerData(Scanner sc) {
        System.out.print("Dia: ");
        int dia = sc.nextInt();

        System.out.print("Mês: ");
        int mes = sc.nextInt();

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        return LocalDate.of(ano, mes, dia);
    }

    private static Moeda lerMoeda(Scanner sc) {
        System.out.println("Moeda:");
        System.out.println("1 - REAL | 2 - DOLAR | 3 - EURO");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                return Moeda.REAL;
            case 2:
                return Moeda.DOLAR;
            case 3:
                return Moeda.EURO;
            default:
                System.out.println("Moeda inválida.");
                return null;
        }
    }

    private static void cadastrarRenda(Scanner sc, Ano ano) {

        LocalDate data = lerData(sc);

        System.out.print("Valor: ");
        BigDecimal valor = sc.nextBigDecimal();

        Moeda moeda = lerMoeda(sc);
        if (moeda == null) return;

        System.out.println("Tipo de renda:");
        System.out.println("1 - SALARIO | 2 - FREELANCE");
        int tipo = sc.nextInt();

        TipoRenda tipoRenda =
                (tipo == 1) ? TipoRenda.SALARIO : TipoRenda.FREELANCE;

        Renda renda = new Renda(data, valor, moeda, tipoRenda);
        ano.adicionarMovimentacao(renda);

        System.out.println("Renda cadastrada com sucesso.");
    }

    private static void cadastrarDespesa(Scanner sc, Ano ano) {

        LocalDate data = lerData(sc);

        System.out.print("Valor: ");
        BigDecimal valor = sc.nextBigDecimal();

        Moeda moeda = lerMoeda(sc);
        if (moeda == null) return;

        System.out.println("Tipo de despesa:");
        System.out.println("1 - ALIMENTACAO | 2 - MORADIA | 3 - TRANSPORTE");
        int tipo = sc.nextInt();

        TipoDespesa tipoDespesa;

        switch (tipo) {
            case 1:
                tipoDespesa = TipoDespesa.ALIMENTACAO;
                break;
            case 2:
                tipoDespesa = TipoDespesa.MORADIA;
                break;
            case 3:
                tipoDespesa = TipoDespesa.TRANSPORTE;
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        Despesa despesa = new Despesa(data, valor, moeda, tipoDespesa);
        ano.adicionarMovimentacao(despesa);

        System.out.println("Despesa cadastrada com sucesso.");
    }

    private static void exibirRelatorio(Scanner sc, Ano ano) {

        System.out.print("Digite o mês (1-12): ");
        int mes = sc.nextInt();

        Moeda moedaPadrao = lerMoeda(sc);
        if (moedaPadrao == null) return;

        RelatorioProgressao relatorio =
                new RelatorioProgressao(moedaPadrao);

        BigDecimal totalRendas =
                relatorio.totalRendasPorMes(ano, mes);

        BigDecimal totalDespesas =
                relatorio.totalDespesasPorMes(ano, mes);

        System.out.println("\n=== RELATÓRIO MENSAL ===");
        System.out.println("Total de Rendas: " + totalRendas + " " + moedaPadrao);
        System.out.println("Total de Despesas: " + totalDespesas + " " + moedaPadrao);
        System.out.println("Saldo: " +
                totalRendas.subtract(totalDespesas) + " " + moedaPadrao);
    }

    private static void exibirRelatorioDiario(Scanner sc, Ano ano) {

        System.out.print("Digite o mês (1-12): ");
        int mes = sc.nextInt();

        Moeda moedaPadrao = lerMoeda(sc);
        if (moedaPadrao == null) return;

        RelatorioProgressao relatorio =
                new RelatorioProgressao(moedaPadrao);

        relatorio.relatorioDiario(ano, mes);
    }
}




