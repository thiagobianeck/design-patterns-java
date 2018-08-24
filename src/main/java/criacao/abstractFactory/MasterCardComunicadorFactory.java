package criacao.abstractFactory;

public class MasterCardComunicadorFactory implements ComunicadorFactory{

    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();

    public Emissor createEmissor() {
        return emissorCreator.create(CartaoBandEnum.MASTERCARD);
    }

    public Receptor createReceptor() {
        return receptorCreator.create(CartaoBandEnum.MASTERCARD);
    }
}
