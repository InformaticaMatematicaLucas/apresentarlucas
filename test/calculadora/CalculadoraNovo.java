package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Testes Unitários - Calculadora")
public class CalculadoraNovo {
	
	
	

	    private Calculadora calculadora;

	    @BeforeEach
	    void setUp() {
	        calculadora = new Calculadora();
	    }

	    @Nested
	    @DisplayName("Operações Aritméticas Básicas")
	    class OperacoesBasicas {

	        @Test
	        @DisplayName("Deve somar dois números corretamente")
	        void deveSomarDoisNumeros() {
	            assertEquals(5, calculadora.soma(2, 3));
	            assertEquals(-1, calculadora.soma(2, -3));
	            assertEquals(0, calculadora.soma(0, 0));
	        }

	        @Test
	        @DisplayName("Deve subtrair dois números corretamente")
	        void deveSubtrairDoisNumeros() {
	            assertEquals(2, calculadora.subtracao(5, 3));
	            assertEquals(8, calculadora.subtracao(5, -3));
	            assertEquals(0, calculadora.subtracao(4, 4));
	        }

	        @Test
	        @DisplayName("Deve multiplicar dois números corretamente")
	        void deveMultiplicarDoisNumeros() {
	            assertEquals(15, calculadora.multiplicacao(3, 5));
	            assertEquals(-15, calculadora.multiplicacao(3, -5));
	            assertEquals(0, calculadora.multiplicacao(10, 0));
	        }

	        @Test
	        @DisplayName("Deve dividir dois números inteiros com sucesso")
	        void deveDividirDoisNumeros() {
	            assertEquals(2, calculadora.divisao(6, 3));
	            assertEquals(2, calculadora.divisao(7, 3)); // Divisão inteira truncada
	            assertEquals(-2, calculadora.divisao(-6, 3));
	        }

	        @Test
	        @DisplayName("Deve lançar ArithmeticException ao dividir por zero")
	        void deveLancarExcecaoAoDividirPorZero() {
	            assertThrows(ArithmeticException.class, () -> calculadora.divisao(10, 0));
	        }
	    }

	    @Nested
	    @DisplayName("Funções de Lógica e Laço")
	    class FuncoesLogicas {

	        @ParameterizedTest(name = "Somatória de {0} deve ser {1}")
	        @CsvSource({
	            "0, 0",
	            "1, 1",
	            "5, 15",   // 5 + 4 + 3 + 2 + 1 + 0 = 15
	            "10, 55",
	            "-1, 0",   // Condição de borda: loop não executa
	            "-5, 0"
	        })
	        @DisplayName("Deve calcular a somatória de n até 0")
	        void deveCalcularSomatoria(int n, int resultadoEsperado) {
	            assertEquals(resultadoEsperado, calculadora.somatoria(n));
	        }

	        @ParameterizedTest(name = "O número {0} deve retornar true para positivo/zero")
	        @ValueSource(ints = {0, 1, 100, Integer.MAX_VALUE})
	        @DisplayName("Deve retornar true para números maiores ou iguais a zero")
	        void deveRetornarTrueParaNumerosPositivosEOZero(int n) {
	            assertTrue(calculadora.ehPositivo(n));
	        }

	        @ParameterizedTest(name = "O número {0} deve retornar false para negativo")
	        @ValueSource(ints = {-1, -10, Integer.MIN_VALUE})
	        @DisplayName("Deve retornar false para números estritamente negativos")
	        void deveRetornarFalseParaNumerosNegativos(int n) {
	            assertFalse(calculadora.ehPositivo(n));
	        }

	        @Test
	        @DisplayName("Deve comparar dois números e retornar 0 (iguais), 1 (a > b) ou -1 (a < b)")
	        void deveCompararValoresCorretamente() {
	            assertAll("comparações",
	                () -> assertEquals(0, calculadora.compara(10, 10), "Valores iguais devem retornar 0"),
	                () -> assertEquals(1, calculadora.compara(15, 10), "a > b deve retornar 1"),
	                () -> assertEquals(-1, calculadora.compara(5, 10), "a < b deve retornar -1"),
	                () -> assertEquals(1, calculadora.compara(0, -5), "0 > -5 deve retornar 1"),
	                () -> assertEquals(-1, calculadora.compara(-10, -5), "-10 < -5 deve retornar -1")
	            );
	        }
	    }
}



