package criacao.factoryMethod;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmissorSMSTest {

    private EmissorCreator creator = new EmissorCreator();
    private Emissor emissor = creator.create(TipoEmissor.SMS);

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissorSMS() {
        assertTrue(emissor instanceof EmissorSMS);
    }

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissor() {
        assertTrue(emissor instanceof Emissor);
    }

    @Test
    public void testaSeMetodoEnviaEhInvocado(){
        emissor = mock(EmissorSMS.class);
        emissor.envia("Mensagem Teste");
        verify(emissor, times(1)).envia(any(String.class));

    }

    @Test
    public void metodoEnviaDeOutraClasseQueImplementaEmissorNaoDeveSerInvocado(){
        emissor = mock(EmissorSMS.class);
        Emissor emissor2 = mock(EmissorJMS.class);

        emissor.envia("Mensagem Teste");
        verify(emissor2, never()).envia(any(String.class));
    }
}