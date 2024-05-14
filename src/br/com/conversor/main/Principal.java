package br.com.conversor.main;

import br.com.conversor.converte.BuscaCambio;
import br.com.conversor.converte.Conversor;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        Scanner scanner = new Scanner(System.in);
        BuscaCambio operacaoDeConverter = new BuscaCambio();

        var escolha = 0;

        while (escolha != 7) {
            System.out.println("\"Bem-vindo às nossas conversões de valores:");
            System.out.println("1-Dólar → Real");
            System.out.println("2-Euro → Real");
            System.out.println("3-Peso Argentino → Real");
            System.out.println("4-Ienes → Real");
            System.out.println("5-Peso Chileno → Real");
            System.out.println("6-Peso Colombiano → Real");
            System.out.println("7-Sair\n");
            try {
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        var moedaDoUsuario = conversor.Converter("USD");
                        System.out.println("Digite o valor que você deseja converter");
                        var valor = scanner.nextDouble();
                        System.out.println("Valor da conversão "+operacaoDeConverter.dolarPraReal(valor, moedaDoUsuario));
                        break;
                    case 2:
                        moedaDoUsuario = conversor.Converter("EUR");
                        System.out.println("Digite o valor que você deseja converter");
                        valor = scanner.nextDouble();
                        System.out.println("Valor da conversão " + operacaoDeConverter.euroPraReal(valor, moedaDoUsuario));
                        break;
                    case 3:
                        moedaDoUsuario = conversor.Converter("ARS");
                        System.out.println("Digite o valor que você deseja converter");
                        valor = scanner.nextDouble();
                        System.out.println("Valor da conversão " + operacaoDeConverter.pesoArgentinoPraReal(valor, moedaDoUsuario));
                        break;
                    case 4:
                        moedaDoUsuario = conversor.Converter("JPY");
                        System.out.println("Digite o valor que você deseja converter");
                        valor = scanner.nextDouble();
                        System.out.println("Valor da conversão " + operacaoDeConverter.ienesParaReal(valor, moedaDoUsuario));
                        break;
                    case 5:
                        moedaDoUsuario = conversor.Converter("CLP");
                        System.out.println("Digite o valor que você deseja converter");
                        valor = scanner.nextDouble();
                        System.out.println("Valor da conversão " + operacaoDeConverter.pesoChilenoPraReal(valor, moedaDoUsuario));
                        break;
                    case 6:
                        moedaDoUsuario = conversor.Converter("COP");
                        System.out.println("Digite o valor que você deseja converter");
                        valor = scanner.nextDouble();
                        System.out.println("Valor da conversão " + operacaoDeConverter.pesoColombianoPraReal(valor, moedaDoUsuario));
                        break;
                    case 7:
                        System.out.println("\nAplicação finalizada");
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error!");
                break;
            }

        }


    }
}
