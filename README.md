# 💰 Financial Management – Java

Projeto desenvolvido com o objetivo de praticar os fundamentos da linguagem Java, programação orientada a objetos e organização de projetos.

O sistema permite o controle simples de rendas e despesas, com suporte a múltiplas moedas e geração de relatórios financeiros.

---

## Objetivos do Projeto

- Praticar Programação Orientada a Objetos em Java
- Trabalhar com datas utilizando `LocalDate`
- Realizar cálculos financeiros com `BigDecimal`
- Utilizar `enum` para padronização de dados
- Separar responsabilidades entre domínio, serviço e interface
- Aprender a estruturar e executar um projeto Java fora da IDE

---

## Funcionalidades

- Cadastro de rendas
- Cadastro de despesas
- Suporte a múltiplas moedas (Real, Dólar e Euro)
- Conversão de valores entre moedas
- Relatório financeiro mensal
- Relatório financeiro diário
- Cálculo automático de saldo

---

## Estrutura do Projeto

src/main/java/
├── thmedeiros_projeto
│ ├── Main.java
│ ├── dominio
│ │ ├── Ano.java
│ │ ├── Movimentacao.java
│ │ ├── Renda.java
│ │ └── Despesa.java
│ ├── enums
│ │ ├── Moeda.java
│ │ ├── TipoRenda.java
│ │ └── TipoDespesa.java
│ └── servico
│ ├── ConversorM.java
│ └── RelatorioProgressao.java

## Como Executar o Projeto

# Pré-requisitos
- Java JDK 11 ou superior
- Terminal (PowerShell, CMD ou similar)

# Passos

"bash
cd src/main/java
javac -encoding UTF-8 thmedeiros_projeto/Main.java
java thmedeiros_projeto.Main"

Conceitos Aplicados

Herança e polimorfismo

Encapsulamento

Uso de classes abstratas

Enumeração de tipos

Separação de responsabilidades

Boas práticas com datas e valores monetários

# Passos

Durante o desenvolvimento deste projeto, foi possível aprender não apenas conceitos da linguagem Java, mas também resolver problemas comuns de ambiente, como:

Organização correta de packages

Configuração de Source Root

Encoding de arquivos

Execução manual via terminal
