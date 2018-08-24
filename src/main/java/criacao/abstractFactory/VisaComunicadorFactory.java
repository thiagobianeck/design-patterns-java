package criacao.abstractFactory;

public class VisaComunicadorFactory implements ComunicadorFactory{

    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();

    public Emissor createEmissor() {
        return emissorCreator.create(CartaoBandEnum.VISA);
    }

    public Receptor createReceptor() {
        return receptorCreator.create(CartaoBandEnum.VISA);
    }
}
