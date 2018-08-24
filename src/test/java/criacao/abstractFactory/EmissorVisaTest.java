package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmissorVisaTest {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private Emissor emissor;

    @Test
    public void deveSerInstanciaDeEmissorVisa() {
        emissor = emissorCreator.create(CartaoBandEnum.VISA);
        assertTrue(emissor instanceof EmissorVisa);
    }

    @Test
    public void deveSErInstanciaDeEmissor(){
        emissor = emissorCreator.create(CartaoBandEnum.VISA);
        assertTrue(emissor instanceof Emissor);
    }

    @Test
    public void deveChamarMetodoEnvia(){
        emissor = mock(EmissorVisa.class);
        emissor.envia("Mensagem Teste");
        verify(emissor, times(1)).envia(any(String.class));
    }

    @Test
    public void naoDeveChamarMetodoEnviaDeOutraClasse(){
        emissor = mock(EmissorVisa.class);
        Emissor emissor2 = mock(EmissorMasterCard.class);
        emissor.envia("Mensagem Teste");
        verify(emissor2, never()).envia(any(String.class));
    }

}