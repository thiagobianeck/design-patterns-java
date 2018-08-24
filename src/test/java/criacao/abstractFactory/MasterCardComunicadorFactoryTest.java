package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MasterCardComunicadorFactoryTest {

    private MasterCardComunicadorFactory factory = new MasterCardComunicadorFactory();
    private Emissor emissor;
    private Receptor receptor;

    @Test
    public void deveCriarInstanciaDeEmissorDoTipoEmissorMasterCard(){
        emissor = factory.createEmissor();
        assertTrue(emissor instanceof Emissor);
        assertTrue(emissor instanceof EmissorMasterCard);
    }

    @Test
    public void deveCriarInstanciaDeReceptorDoTipoReceptorMasterCard(){
        receptor = factory.createReceptor();
        assertTrue(receptor instanceof Receptor);
        assertTrue(receptor instanceof ReceptorMasterCard);
    }
}