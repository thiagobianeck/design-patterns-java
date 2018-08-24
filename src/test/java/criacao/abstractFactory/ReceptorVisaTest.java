package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ReceptorVisaTest {

    private ReceptorCreator receptorCreator = new ReceptorCreator();
    private Receptor receptor;

    @Test
    public void deveSerInstanciaDeReceptorVisa() {
        receptor = receptorCreator.create(CartaoBandEnum.VISA);
        assertTrue(receptor instanceof ReceptorVisa);
    }

    @Test
    public void deveSerInstanciaDeReceptor(){
        receptor = receptorCreator.create(CartaoBandEnum.VISA);
        assertTrue(receptor instanceof Receptor);
    }

    @Test
    public void deveChamarMetodoRecebe(){
        receptor = mock(ReceptorVisa.class);
        receptor.recebe();
        verify(receptor, times(1)).recebe();
    }

    @Test
    public void deveRetornarMensagemAoInvocarMetodoRecebe(){
        receptor = receptorCreator.create(CartaoBandEnum.VISA);
        assertEquals("Mensagem da Visa",receptor.recebe());
    }

    @Test
    public void naoDeveChamarMetodoEnviaDeOutraClasse(){
        receptor = mock(ReceptorVisa.class);
        Receptor receptor2 = mock(ReceptorMasterCard.class);
        receptor.recebe();
        verify(receptor2, never()).recebe();
    }

}