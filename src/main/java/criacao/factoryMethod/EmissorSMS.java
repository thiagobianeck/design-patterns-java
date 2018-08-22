package criacao.factoryMethod;

public class EmissorSMS implements Emissor{

    public void envia(String mensagem) {
        System.out.println("Enviando por sms a mensagem: ");
        System.out.println(mensagem);
    }
}
