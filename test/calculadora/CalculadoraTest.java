package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
   
    	  
      Calculadora c = new Calculadora();
    	  
     
      @Test
      public void teste_soma()
      {
    	 int validar = 0 ;
    	 Assertions.assertEquals(validar,c.soma(-5, 5));
    	
      }
      @Test
      public void teste_subtracao()
      {
    	  int validar = - 5 - 5;
    	  Assertions.assertEquals(validar,c.subtracao(-5,5));
      }
      @Test
      public void testemultiplicacao() 
      {
    	  int validar = 5 * 1;
    	  Assertions.assertEquals(validar,c.multiplicacao(5,1));
      }
      @Test
      public void testedivisao()
      {
    	  try
    	  {
    		  Assertions.assertEquals(3,c.divisao(3,0));
    	  }catch(Exception e)
    	  {
    		  System.out.println(e);
    	  }
    	  
      }
      @Test
      public void testsomatorio()
      {
    	  int resultado = c.somatoria(5);
          Assertions.assertNotEquals(20,resultado);
      }
      @Test
      public void teste_ehpositivo()
      {
    	  boolean resultado = c.ehPositivo(-1);
    	 
    	  Assertions.assertNotEquals(resultado,"Nao e positivo");
    	 
      }
}
