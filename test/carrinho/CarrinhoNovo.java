package carrinho;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoNovo {
	private Carrinho carrinho;
    private Produto livro;
    private Produto caneta;
    private Produto caderno;
    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        livro = new Produto("Livro", 50.0);
        caneta = new Produto("Caneta", 5.50);
        caderno = new Produto("Caderno", 20.0);
    }

    @Nested
    @DisplayName("Estado Inicial")
    class EstadoInicial {

        @Test
        @DisplayName("Deve iniciar o carrinho vazio com total zerado")
        void deveIniciarCarrinhoVazio() {
            assertAll("Verificações do estado inicial",
                () -> assertEquals(0, carrinho.getQtdeItems(), "Quantidade inicial de itens deve ser 0"),
                () -> assertEquals(0.0, carrinho.getValorTotal(), 0.0001, "Valor total inicial deve ser 0.0")
            );
        }
    }
    @Nested
    @DisplayName("Adição de Itens")
    class AdicaoItens {

        @Test
        @DisplayName("Deve adicionar um produto e atualizar quantidade e valor total")
        void deveAdicionarUmItemComSucesso() {
            carrinho.addItem(livro);

            assertAll("Verificações após adicionar um item",
                () -> assertEquals(1, carrinho.getQtdeItems()),
                () -> assertEquals(50.0, carrinho.getValorTotal(), 0.0001)
            );
        }

        @Test
        @DisplayName("Deve adicionar múltiplos produtos e somar corretamente os valores")
        void deveAdicionarMultiplosItens() {
            carrinho.addItem(livro);
            carrinho.addItem(caneta);
            carrinho.addItem(caderno);

            assertAll("Verificações após múltiplos itens",
                () -> assertEquals(3, carrinho.getQtdeItems()),
                () -> assertEquals(75.50, carrinho.getValorTotal(), 0.0001)
            );
        }
    }
    @Nested
    @DisplayName("Remoção de Itens")
    class RemocaoItens {

        @Test
        @DisplayName("Deve remover um item existente com sucesso")
        void deveRemoverItemExistente() throws ProdutoNaoEncontradoException {
            carrinho.addItem(livro);
            carrinho.addItem(caneta);

            carrinho.removeItem(livro);

            assertAll("Verificações após remover o livro",
                () -> assertEquals(1, carrinho.getQtdeItems()),
                () -> assertEquals(5.50, carrinho.getValorTotal(), 0.0001)
            );
        }
        
        @Test
        @DisplayName("Deve remover item com base na igualdade de nome definida em Produto#equals")
        void deveRemoverItemPorIgualdadeDeNome() throws ProdutoNaoEncontradoException {
            carrinho.addItem(livro);
            Produto livroEquivalente = new Produto("Livro", 999.0);

            carrinho.removeItem(livroEquivalente);

            assertEquals(0, carrinho.getQtdeItems());
            assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
        }
        
        @Test
        @DisplayName("Deve lançar ProdutoNaoEncontradoException ao tentar remover item inexistente")
        void deveLancarExcecaoAoRemoverItemInexistente() {
            carrinho.addItem(livro);

            assertThrows(ProdutoNaoEncontradoException.class, () -> {
                carrinho.removeItem(caneta);
            });
        }

        @Test
        @DisplayName("Deve lançar ProdutoNaoEncontradoException ao tentar remover de um carrinho vazio")
        void deveLancarExcecaoAoRemoverDeCarrinhoVazio() {
            assertThrows(ProdutoNaoEncontradoException.class, () -> {
                carrinho.removeItem(livro);
            });
        }
    }
    
    @Nested
    @DisplayName("Esvaziar Carrinho")
    class EsvaziarCarrinho {

        @Test
        @DisplayName("Deve esvaziar o carrinho com múltiplos itens e zerar o total")
        void deveEsvaziarCarrinhoComItens() {
            carrinho.addItem(livro);
            carrinho.addItem(caneta);

            carrinho.esvazia();

            assertAll("Verificações após esvaziar carrinho",
                () -> assertEquals(0, carrinho.getQtdeItems()),
                () -> assertEquals(0.0, carrinho.getValorTotal(), 0.0001)
            );
        }
        
        @Test
        @DisplayName("Deve manter o estado correto ao executar esvazia em carrinho já vazio")
        void deveManterEstadoAoEsvaziarCarrinhoJaVazio() {
            carrinho.esvazia();

            assertEquals(0, carrinho.getQtdeItems());
            assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
        }
    }
}
