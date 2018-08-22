package criacao.factoryMethod;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmissorCreatorTest {

    private EmissorCreator emissorCreator = new EmissorCreator();


    @Test
    public void deveRetornarObjetoDoTipoEmissorSMS() {
        Emissor emissor = emissorCreator.create(TipoEmissor.SMS);
        assertTrue(emissor instanceof EmissorSMS);
    }

    @Test
    public void naoDeveRetornarObjetoDiferenteDeTipoEmissorSMS() {
        Emissor emissor = emissorCreator.create(TipoEmissor.SMS);
        assertFalse(emissor instanceof EmissorEmail);
    }

    @Test
    public void deveRetornarObjetoDoTipoEmissorEmail() {
        Emissor emissor = emissorCreator.create(TipoEmissor.EMAIL);
        emissor.envia("Mensagem");
        assertTrue(emissor instanceof EmissorEmail);
    }

    @Test
    public void deveRetornarObjetoDoTipoEmissorJMS() {
        Emissor emissor = emissorCreator.create(TipoEmissor.JMS);
        assertTrue(emissor instanceof EmissorJMS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcessaoPorTipoInvalido() {
        Emissor emissor = emissorCreator.create(TipoEmissor.FAKE);
    }


}