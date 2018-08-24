package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ReceptorMasterCardTest {

    private ReceptorCreator receptorCreator = new ReceptorCreator();
    private Receptor receptor;

    @Test
    public void deveSerInstanciaDeReceptorMasterCard() {
        receptor = receptorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(receptor instanceof ReceptorMasterCard);
    }

    @Test
    public void deveSerInstanciaDeReceptor(){
        receptor = receptorCreator.create(CartaoBandEnum.MASTERCARD);
        assertTrue(receptor instanceof Receptor);
    }

    @Test
    public void deveChamarMetodoRecebe(){
        receptor = mock(ReceptorMasterCard.class);
        receptor.recebe();
        verify(receptor, times(1)).recebe();
    }

    @Test
    public void deveRetornarMensagemAoInvocarMetodoRecebe(){
        receptor = receptorCreator.create(CartaoBandEnum.MASTERCARD);
        assertEquals("Mensagem da MasterCard",receptor.recebe());
    }

    @Test
    public void naoDeveChamarMetodoEnviaDeOutraClasse(){
        receptor = mock(ReceptorMasterCard.class);
        Receptor receptor2 = mock(ReceptorVisa.class);
        receptor.recebe();
        verify(receptor2, never()).recebe();
    }

}