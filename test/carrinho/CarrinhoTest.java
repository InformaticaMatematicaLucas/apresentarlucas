package carrinho;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import produto.Produto;

public class CarrinhoTest {
	
	Produto p = new Produto("A1",0.34);
	Carrinho car = new Carrinho();
	
	@Test
	public void testeadditem()
	{
		car.addItem(p);
		int a = car.getQtdeItems();
		System.out.print(a);
		Assertions.assertNotNull(car);
	}
	@Test
	public void testeQtdITem()
	{
		Assertions.assertEquals(0, car.getQtdeItems());
	}

}
