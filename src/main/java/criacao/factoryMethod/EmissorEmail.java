package criacao.factoryMethod;

public class EmissorEmail implements Emissor{

    public void envia(String mensagem) {
        System.out.println("Enviando por email a mensagem: " + mensagem);
    }
}
