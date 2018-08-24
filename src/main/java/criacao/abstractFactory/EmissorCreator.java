package criacao.abstractFactory;

public class EmissorCreator {

    public Emissor create(CartaoBandEnum bandEnum){
        switch (bandEnum){
            case VISA:
                return new EmissorVisa();
            case MASTERCARD:
                return new EmissorMasterCard();
            default:
                throw new IllegalArgumentException("Tipo de emissor não suportado");
        }
    }
}
