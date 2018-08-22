package criacao.factoryMethod;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmissorJMSTest {

    private EmissorCreator creator = new EmissorCreator();
    private Emissor emissor = creator.create(TipoEmissor.JMS);

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissorJMS() {
        assertTrue(emissor instanceof EmissorJMS);
    }

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissor() {
        assertTrue(emissor instanceof Emissor);
    }

    @Test
    public void testaSeMetodoEnviaEhInvocado(){
        emissor = mock(EmissorJMS.class);
        emissor.envia("Mensagem Teste");
        verify(emissor, times(1)).envia(any(String.class));

    }

    @Test
    public void metodoEnviaDeOutraClasseQueImplementaEmissorNaoDeveSerInvocado(){
        emissor = mock(EmissorJMS.class);
        Emissor emissor2 = mock(EmissorSMS.class);

        emissor.envia("Mensagem Teste");
        verify(emissor2, never()).envia(any(String.class));
    }
}