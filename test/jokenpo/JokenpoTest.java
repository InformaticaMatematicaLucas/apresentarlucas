package jokenpo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JokenpoTest {
     
	 @Test
	 public void validarTipoJogada()
     {
    	 Jokenpo joke = new Jokenpo();
    	 
    	 Assertions.assertEquals(1,joke.jogar(1, 2));
    	 Assertions.assertEquals(0,joke.jogar(1, 1));
    	 Assertions.assertEquals(2,joke.jogar(3, 2));
    	 Assertions.assertEquals(2,joke.jogar(2, 3));// jogador1 = pedra e jogador2  = tesoura <=> entao resultado esperado e 1 mas coloquei 2;
    	 Assertions.assertEquals(2,joke.jogar(1, 3));
    	 Assertions.assertEquals(1,joke.jogar(3, 1));
    	 Assertions.assertEquals(2,joke.jogar(2, 1));
     }
}
