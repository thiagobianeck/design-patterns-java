package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmissorMastercardTest {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private Emissor emissor;

    @Test
    public void deveSerInstanciaDeEmissorMasterCard() {
        emissor = emissorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(emissor instanceof EmissorMasterCard);
    }

    @Test
    public void deveSerInstanciaDeEmissor(){
        emissor = emissorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(emissor instanceof Emissor);
    }

    @Test
    public void deveChamarMetodoEnvia(){
        emissor = mock(EmissorMasterCard.class);
        emissor.envia("Mensagem Teste");
        verify(emissor, times(1)).envia(any(String.class));
    }

    @Test
    public void naoDeveChamarMetodoEnviaDeOutraClasse(){
        emissor = mock(EmissorMasterCard.class);
        Emissor emissor2 = mock(EmissorVisa.class);
        emissor.envia("Mensagem Teste");
        verify(emissor2, never()).envia(any(String.class));
    }

}