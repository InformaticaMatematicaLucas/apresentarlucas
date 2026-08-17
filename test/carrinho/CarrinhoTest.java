package carrinho;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import produto.Produto;

public class CarrinhoTest {
	
	
	
	@Test
	public void testeadditem()
	{
		Produto p = new Produto("A1",0.34);
		Carrinho car = new Carrinho();
		car.addItem(p);
		Assertions.assertNotNull(car);
	}
	@Test
	public void testeQtdITem()
	{
		Produto p = new Produto("A1",0.34);
		Carrinho car = new Carrinho();
		car.addItem(p);
		Assertions.assertEquals(1, car.getQtdeItems());
	}
	
	@Test
	public void testeValorTotal()
	{
		
		Produto p = new Produto("A1",0.34);
		Carrinho car = new Carrinho();
		car.addItem(p);
		double valor = 0.34;
		
		Assertions.assertEquals(valor, car.getValorTotal());
		
		
	}
	
	

}
