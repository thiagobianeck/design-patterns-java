package criacao.factoryMethod;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmissorEmailTest {

    private EmissorCreator creator = new EmissorCreator();
    private Emissor emissor = creator.create(TipoEmissor.EMAIL);

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissorEmail() {
        assertTrue(emissor instanceof EmissorEmail);
    }

    @Test
    public void testaSeObjetoCriadoEhDotipoEmissor() {
        assertTrue(emissor instanceof Emissor);
    }

    @Test
    public void testaSeMetodoEnviaEhInvocado(){
        emissor = mock(EmissorEmail.class);
        emissor.envia("Mensagem Teste");
        verify(emissor, times(1)).envia(any(String.class));
    }

    @Test
    public void metodoEnviaDeOutraClasseQueImplementaEmissorNaoDeveSerInvocado(){
        emissor = mock(EmissorEmail.class);
        Emissor emissor2 = mock(EmissorJMS.class);

        emissor.envia("Mensagem Teste");
        verify(emissor2, never()).envia(any(String.class));
    }
}