package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;

public class javatestTest {

    @Test
    public void testEntradaValidaComABC() {
        List<String> resultado = javatest.processarEntrada("abc");

        assertEquals(6, resultado.size());
        assertTrue(resultado.contains("abc"));
        assertTrue(resultado.contains("acb"));
        assertTrue(resultado.contains("bac"));
        assertTrue(resultado.contains("bca"));
        assertTrue(resultado.contains("cab"));
        assertTrue(resultado.contains("cba"));
    }

    @Test
    public void testEntradaVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            javatest.processarEntrada(""); // Teste para entrada vazia
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComNumero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            javatest.processarEntrada("a2c"); // Teste para entrada com números
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComCaracteresEspeciais() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            javatest.processarEntrada("a*c"); // Teste para entrada com caracteres especiais
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComUmaLetra() {
        List<String> resultado = javatest.processarEntrada("a");

        assertEquals(1, resultado.size());
        assertTrue(resultado.contains("a"));
    }

    @Test
    public void testEntradaComDuasLetras() {
        List<String> resultado = javatest.processarEntrada("ab");

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains("ab"));
        assertTrue(resultado.contains("ba"));
    }
}