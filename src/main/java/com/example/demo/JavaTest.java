package com.example.demo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaTest {

    public static void main(String[] args) {

        // A início chamando o teclado para a entrada de dados
        Scanner teclado = new Scanner(System.in);
        String entrada;

        // Loop para continuar pedindo entradas até o usuário decidir sair
        while (true) {
            System.out.print("Digite apenas letras para gerar os anagramas: ");
            entrada = teclado.nextLine().trim();

            try { // Ele valida se é uma entrada válida chamando o método processarEntrada... caso seja válida, ele segue
                Set<String> anagramas = processarEntrada(entrada);
                System.out.println("Total de anagramas únicos: " + anagramas.size());
                System.out.println("Anagramas de '" + entrada + "': " + anagramas);
            } catch (IllegalArgumentException e) { // Caso a entrada seja inválida, ele cai no catch retornando uma mensagem de erro
                System.out.println(e.getMessage()); // Mensagem de erro padronizada
                continue; // Pede nova entrada sem interromper o loop
            }

            // Pergunta se gostaria de continuar com outro anagrama
            System.out.print("Deseja digitar outra palavra? (S/N): ");
            String resposta = teclado.nextLine().trim().toLowerCase();

            // Se a resposta for diferente de "s" ou "sim", ele encerra
            if (!resposta.equals("s") && !resposta.equals("sim")) {
                System.out.println("Programa encerrado. Até mais!");
                break;
            }
        }

        teclado.close();
    }

    // Método que verifica se a entrada é válida
    public static Set<String> processarEntrada(String entrada) {
        // Se for igual a nulo, vazio ou diferente de letras, ele dá erro
        if (entrada == null || entrada.isEmpty() || !entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Entrada inválida. Certifique-se de digitar apenas letras.");
        }

        // Se for apenas uma letra, retorna mensagem de erro
        if (entrada.length() == 1) {
            throw new IllegalArgumentException("Digite mais de uma letra para formar um anagrama.");
        }

        // Se a entrada for válida, gera os anagramas
        Set<String> resultado = new LinkedHashSet<>(); // Usa LinkedHashSet para garantir anagramas únicos e manter ordem
        gerarCombinacoes("", entrada, resultado);
        return resultado;
    }

    // Método verifica a quantidade de letras digitadas e faz o anagrama
    private static void gerarCombinacoes(String prefixo, String restante, Set<String> resultado) {
        int tamanho = restante.length();
        if (tamanho == 0) {
            resultado.add(prefixo); // Adiciona ao Set, eliminando repetições automaticamente
        } else {
            for (int i = 0; i < tamanho; i++) {
                gerarCombinacoes(prefixo + restante.charAt(i), restante.substring(0, i) + restante.substring(i + 1), resultado);
            }
        }
    }
}