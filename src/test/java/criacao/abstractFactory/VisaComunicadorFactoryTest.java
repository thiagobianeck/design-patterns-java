package criacao.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VisaComunicadorFactoryTest {

    private VisaComunicadorFactory factory = new VisaComunicadorFactory();
    private Emissor emissor;
    private Receptor receptor;

    @Test
    public void deveCriarInstanciaDeEmissorDoTipoEmissorVisa(){
        emissor = factory.createEmissor();
        assertTrue(emissor instanceof Emissor);
        assertTrue(emissor instanceof EmissorVisa);
    }

    @Test
    public void deveCriarInstanciaDeReceptorDoTipoReceptorVisa(){
        receptor = factory.createReceptor();
        assertTrue(receptor instanceof Receptor);
        assertTrue(receptor instanceof ReceptorVisa);
    }
}