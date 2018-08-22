package criacao.factoryMethod;

public class EmissorCreator {

    public Emissor create(TipoEmissor tipoDeEmissor) {
        switch (tipoDeEmissor){
            case SMS:
                return new EmissorSMS();
            case EMAIL:
                return new EmissorEmail();
            case JMS:
                return new EmissorJMS();
            default:
                throw new IllegalArgumentException("Tipo de Emissor não suportado");
        }
    }
}
