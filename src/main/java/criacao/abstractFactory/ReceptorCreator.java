package criacao.abstractFactory;

public class ReceptorCreator {

    public Receptor create(CartaoBandEnum bandEnum){
        switch (bandEnum) {
            case VISA:
                return new ReceptorVisa();
            case MASTERCARD:
                return new ReceptorMasterCard();
            default:
                throw new IllegalArgumentException("Tipo de Receptor não suportado.");
        }
    }
}
