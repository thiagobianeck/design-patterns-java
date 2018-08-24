package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmissorCreatorTest {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private Emissor emissor;

    @Test
    public void deveCriarInstanciaEmissorVisa() {
        emissor = emissorCreator.create(CartaoBandEnum.VISA);
        assertTrue(emissor instanceof EmissorVisa);
    }

    @Test
    public void deveCriarInstanciaEmissorMasterCard() {
        emissor = emissorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(emissor instanceof EmissorMasterCard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaEmissorNaoSuportado(){
        emissor = emissorCreator.create(CartaoBandEnum.TEST);
    }

    @Test
    public void naoDeveCriarInstanciaDeClasseDiferenteQuandoCriarEmissorVisa(){
        emissor = emissorCreator.create(CartaoBandEnum.VISA);
        assertFalse(emissor instanceof EmissorMasterCard);
    }

}