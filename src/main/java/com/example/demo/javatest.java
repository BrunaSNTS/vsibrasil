package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class javatest {

    public static void main(String[] args) {

        //a inicio chamando o teclado para a entrada de dados
        Scanner teclado = new Scanner(System.in);
        String entrada;

        // Loop para continuar pedindo entradas até o usuário decidir sair
        while (true) {
            System.out.print("Digite apenas letras para gerar os anagramas: ");
            entrada = teclado.nextLine().trim();

            try { // ele valida se é uma entrada valida chamando o metodo processarEntrada... caso seja valida, ele segue
                List<String> anagramas = processarEntrada(entrada);
                System.out.println("Total de anagramas: " + anagramas.size());
                System.out.println("Anagramas de '" + entrada + "': " + anagramas);
            } catch (IllegalArgumentException e) { // Caso a entrada seja invalida, ele cai no catch retornando uma mensagem de erro
                System.out.println(e.getMessage()); // Mensagem de erro padronizada
                continue; // Pede nova entrada sem interromper o loop
            }

            //pergunta se gostaria de continuar com outro anagrama
            System.out.print("Deseja digitar outra palavra? (S/N): ");
            String resposta = teclado.nextLine().trim().toLowerCase();

            //se a resposta for diferente de "s" ou "sim", ele encerra
            if (!resposta.equals("s") && !resposta.equals("sim")) {
                System.out.println("Programa encerrado. Até mais!");
                break;
            }
        }

        teclado.close();
    }

    //metodo que verifica se a entrada é valida
    public static List<String> processarEntrada(String entrada) {
        // se for igual a nulo, vazio ou diferente de letras, ele da erro
        if (entrada == null || entrada.isEmpty() || !entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Entrada inválida. Certifique-se de digitar apenas letras.");
        }

        // Se a entrada for válida, gera os anagramas
        List<String> resultado = new ArrayList<>();
        gerarCombinacoes("", entrada, resultado);
        return resultado;
    }


    // Metodo verifica a quantidade de letras digitadas e faz o anagrama
    private static void gerarCombinacoes(String prefixo, String restante, List<String> resultado) {
        int tamanho = restante.length();
        if (tamanho == 0) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < tamanho; i++) {
                gerarCombinacoes(prefixo + restante.charAt(i), restante.substring(0, i) + restante.substring(i + 1), resultado);
            }
        }
    }
}