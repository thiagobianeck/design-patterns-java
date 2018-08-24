package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReceptorCreatorTest {

    private ReceptorCreator receptorCreator = new ReceptorCreator();
    private Receptor receptor;

    @Test
    public void deveRetornarInstanciaReceptorVisa(){
        receptor = receptorCreator.create(CartaoBandEnum.VISA);
        assertTrue(receptor instanceof ReceptorVisa);
    }

    @Test
    public void deveRetornarInstanciaReceptorMasterCard(){
        receptor = receptorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(receptor instanceof ReceptorMasterCard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaTipoDeReceptorNaoSuportado(){
        receptor = receptorCreator.create(CartaoBandEnum.TEST);
    }

    @Test
    public void naoDeveCriarInstanciaDeClasseDiferenteQuandoCriarReceptorVisa(){
        receptor = receptorCreator.create(CartaoBandEnum.VISA);
        assertFalse(receptor instanceof ReceptorMasterCard);
    }

}