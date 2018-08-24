package criacao.abstractFactory;

public interface ComunicadorFactory {
    Emissor createEmissor();
    Receptor createReceptor();
}
