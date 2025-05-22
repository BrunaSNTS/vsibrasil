package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Set;

public class JavaTestTest {

    @Test
    public void testEntradaValidaComABC() {
        Set<String> resultado = JavaTest.processarEntrada("abc");

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
            JavaTest.processarEntrada(""); // Teste para entrada vazia
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComNumero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            JavaTest.processarEntrada("a2c"); // Teste para entrada com números
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComCaracteresEspeciais() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            JavaTest.processarEntrada("a*c"); // Teste para entrada com caracteres especiais
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }

    @Test
    public void testEntradaComUmaLetra() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            JavaTest.processarEntrada("a"); // Teste para entrada com apenas uma letra
        });

        assertEquals("Digite mais de uma letra para formar um anagrama.", exception.getMessage());
    }

    @Test
    public void testEntradaComDuasLetras() {
        Set<String> resultado = JavaTest.processarEntrada("ab");

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains("ab"));
        assertTrue(resultado.contains("ba"));
    }
    @Test
    public void testEntradaComEspacos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            JavaTest.processarEntrada("a b"); // Teste para entrada com espaços
        });

        assertEquals("Entrada inválida. Certifique-se de digitar apenas letras.", exception.getMessage());
    }
    @Test
    public void testEntradaComLetrasMaiusculasEMinusculas() {
        Set<String> resultado = JavaTest.processarEntrada("AbC");

        assertEquals(6, resultado.size());
        assertTrue(resultado.contains("AbC"));
        assertTrue(resultado.contains("ACb"));
        assertTrue(resultado.contains("bAC"));
        assertTrue(resultado.contains("bCA"));
        assertTrue(resultado.contains("CAb"));
        assertTrue(resultado.contains("CbA"));
    }

}